package bean;
import java.util.List;

public interface GoodDao {
    public List<Good> getGoods();
    public int add(Good goodbean);
    public int delete(String goodId);
    public int update(Good goodbean);
    public Good findById(String goodId);
    public void export();
}
