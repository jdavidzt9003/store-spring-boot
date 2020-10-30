package com.bolivar.store.repositories;
import com.bolivar.store.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Map;
@Repository
public class ProductImpl implements ProductRepository {

    private SimpleJdbcCall simpleJdbcCall;
    @Autowired
    private DataSource dataSource;

    public void setDatasource(DataSource datasource) {
        this.simpleJdbcCall = new SimpleJdbcCall(datasource)
                .withCatalogName("products_pkg")
                .withProcedureName("get_product");
    }

    @Override
    public Product getProduct(int id) {
        setDatasource(dataSource);
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("id", id);
        Map<String, Object> out = simpleJdbcCall.execute(in);
        Product product = new Product();
        product.setId(id);
        product.setName((String)out.get("OUT_NAME"));
        product.setDescription((String)out.get("OUT_DESCRIPTION"));
        return product;
    }
}
