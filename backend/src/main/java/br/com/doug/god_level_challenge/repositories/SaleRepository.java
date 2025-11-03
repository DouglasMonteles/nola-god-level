package br.com.doug.god_level_challenge.repositories;

import br.com.doug.god_level_challenge.models.Sale;
import br.com.doug.god_level_challenge.models.dtos.SaleBasicInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(value = """
    select\s
        s.id,
        s.sale1,
        s.sale2,
        s.customer_name,
        s.delivery_fee,
        s.delivery_seconds,
        s.discount_reason,
        s.increase_reason,
        s.origin,
        s.people_quantity,
        s.production_seconds,
        s.sale_status_desc,
        s.service_tax_fee,
        s.total_amount,
        s.total_amount_items,
        s.total_discount,
        s.total_increase,
        s.value_paid,
        s.created_at,
        c.name as channel_name,
        st.name as store_name,
        sb.name as sub_brand_name\s
    from sales s\s
        left join channels c\s
            on s.channel_id = c.id\s
        left join stores st\s
            on s.store_id = st.id\s
        left join sub_brands sb\s
            on s.sub_brand_id = sb.id\s
        where s.id = :saleId
    """,
    nativeQuery = true)
    SaleBasicInfoDTO findBySaleId(@Param("saleId") Long saleId);

}
