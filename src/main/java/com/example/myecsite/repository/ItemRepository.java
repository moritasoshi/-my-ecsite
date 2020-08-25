package com.example.myecsite.repository;

import com.example.myecsite.domain.Item;
import com.example.myecsite.domain.ItemPage;
import com.example.myecsite.domain.SearchItem;
import com.example.myecsite.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Item> ITEM_ROW_MAPPER = (rs, i) -> {
        Item item = new Item();
        item.setId(rs.getInt("id"));
        item.setName(rs.getString("name"));
        item.setDescription(rs.getString("description"));
        item.setPriceM(rs.getInt("price_m"));
        item.setPriceL(rs.getInt("price_l"));
        item.setImagePath(rs.getString("image_path"));
        item.setDeleted(rs.getBoolean("deleted"));
        return item;
    };

    /**
     * @return [フラグ]deleted=falseの商品一覧を返す
     */
    public List<Item> findAll() {
        String sql = "SELECT id, name, description, price_m, price_l, image_path, deleted FROM items WHERE deleted = false ORDER BY price_m";
        List<Item> itemList = template.query(sql, ITEM_ROW_MAPPER);
        return itemList;
    }

    /**
     * @return 曖昧検索に一致した商品一覧を返す
     */
    public List<Item> findByName(String name) {
        String sql = "SELECT id, name, description, price_m, price_l, image_path, deleted FROM items WHERE deleted = false AND name LIKE :name ORDER BY price_m";
        SqlParameterSource param = new MapSqlParameterSource().addValue("name", "%" + name + "%");
        List<Item> itemList = template.query(sql, param, ITEM_ROW_MAPPER);
        return itemList;
    }

    /**
     * 任意の商品情報を返す
     *
     * @param id
     * @return 任意の1件の商品情報を返す
     */
    public Item load(Integer id) {
        String sql = "SELECT id, name, description, price_m, price_l, image_path, deleted FROM items WHERE deleted = false AND id = :id";
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        List<Item> itemList = template.query(sql, param, ITEM_ROW_MAPPER);
        if (itemList.isEmpty()) {
            return null;
        }
        return itemList.get(0);
    }

    /**
     * 商品検索
     *
     * @return 検索条件に一致した商品リストを返す
     */
    public ItemPage findBySearchTerms(SearchItem searchItem) {
        final Integer page = searchItem.getPage();
        final String orderColumn = searchItem.getSortEnum().getColumn() + " " + searchItem.getSortEnum().getOrder();
        final Integer limit = searchItem.getPageSize();
        final Integer offset = limit * (page - 1);

        String sql = "SELECT * FROM items WHERE name LIKE :name ORDER BY " + orderColumn + " LIMIT :limit OFFSET :offset ;";
        String countSql = "SELECT COUNT(*) FROM items WHERE name LIKE :name";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("name", "%" + searchItem.getName() + "%")
                .addValue("limit", limit)
                .addValue("offset", offset);

        List<Item> itemList = template.query(sql, param, ITEM_ROW_MAPPER);
        Integer size = template.queryForObject(countSql, param, Integer.class);

        ItemPage itemPage = new ItemPage(itemList, size, page, limit, size / limit + 1);
        return itemPage;
    }
}
