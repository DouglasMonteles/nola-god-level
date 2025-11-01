package br.com.doug.god_level_challenge.repositories;

import br.com.doug.god_level_challenge.models.Product;
import br.com.doug.god_level_challenge.models.dtos.QuantityProductSaleByPeriodDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(
        value = """
                select\s
                    t.product_id,
                    t.product_name,
                    t.product_quantity_on_sale,
                    prod_sales.id as sale_id,
                    prod_sales.quantity as quantity_on_sale,
                    sl.created_at\s
                from product_sales prod_sales\s
                join (select id, created_at from sales) sl\s
                    on sl.id = prod_sales.sale_id\s
                join (
                    select\s
                        p.id as product_id,
                        p.name as product_name,
                        sum(ps.quantity) AS product_quantity_on_sale\s
                    from products p\s
                        inner join product_sales ps\s
                            on p.id = ps.product_id\s
                        inner join sales s\s
                            on s.id = ps.sale_id\s
                        inner join channels c\s
                            on c.id = s.channel_id\s
                    where\s
                        c.name = :channelName\s
                        and s.sale_status_desc = :saleStatusDesc\s
                        and s.created_at between :initialDateTime\s
                        and :finalDateTime group by p.id
                ) t on t.product_id = prod_sales.product_id
                """,
        countQuery = "SELECT COUNT(*) FROM (select p.id from products p inner join product_sales ps on p.id = ps.product_id inner join sales s on s.id = ps.sale_id inner join channels c on c.id = s.channel_id where c.name = :channelName and s.sale_status_desc = :saleStatusDesc and s.created_at between :initialDateTime AND :finalDateTime group by p.id) total",
        nativeQuery = true
    )
    Page<QuantityProductSaleByPeriodDTO> findQuantityProductSaleByPeriod(
            @Param("saleStatusDesc") String saleStatusDesc,
            @Param("channelName") String channelName,
            @Param("initialDateTime") LocalDateTime initialDateTime,
            @Param("finalDateTime") LocalDateTime finalDateTime,
            Pageable pageable
    );

}
