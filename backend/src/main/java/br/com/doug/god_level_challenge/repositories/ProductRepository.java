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
                    t.product_quantity_total_sales,
                    sl.id as sale_id,
                    prod_sales.quantity as quantity_on_sale,
                    sl.created_at\s
                from product_sales prod_sales\s
                join (
                    select\s
                        sales.id,
                        sales.created_at\s
                    from sales sales\s
                    inner join channels c\s
                        on c.id = sales.channel_id\s
                    where\s
                        c.name = :channelName\s
                        and sales.sale_status_desc = :saleStatusDesc\s
                        and sales.created_at between :initialDateTime and :finalDateTime
                ) sl\s
                    on sl.id = prod_sales.sale_id\s
                join (
                    select\s
                        p.id as product_id,
                        p.name as product_name,
                        sum(ps.quantity) AS product_quantity_total_sales\s
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
                        and s.created_at between :initialDateTime and :finalDateTime\s
                    group by p.id\s
                    order by product_quantity_total_sales desc
                    limit 1
                ) t on t.product_id = prod_sales.product_id\s
                order by sl.created_at asc
                """,
        countQuery = """
        select count(*) from (
            select\s
                t.product_id
            from product_sales prod_sales\s
            join (
                select\s
                    id
                from sales sales\s
                where\s
                    sales.sale_status_desc = :saleStatusDesc\s
                    and sales.created_at between :initialDateTime and :finalDateTime
            ) sl\s
                on sl.id = prod_sales.sale_id\s
            join (
                select\s
                    p.id as product_id,
                    sum(ps.quantity) AS product_quantity_total_sales\s
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
                    and s.created_at between :initialDateTime and :finalDateTime\s
                group by p.id\s
                order by product_quantity_total_sales desc
                limit 1
            ) t on t.product_id = prod_sales.product_id
        ) total
        """,
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
