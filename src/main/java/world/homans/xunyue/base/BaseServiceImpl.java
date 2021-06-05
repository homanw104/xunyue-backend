package world.homans.xunyue.base;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Search;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
@Service
@Slf4j
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {
 //   @Autowired
   // @Resource
    //public JestClient jestClient;

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(BaseServiceImpl.class);

    public abstract Mapper<T> getMapper();

    @Override
    public T selectOne(T record) {
        List<T> results = getMapper().select(record);
        if (CollectionUtils.isNotEmpty(results)) return results.get(0);
        else return null;
    }

    @Override
    public List<?> search(String searchContent)  {
        // TODO for hhp 实现模糊搜索单个表接口 https://www.jianshu.com/p/8f226206ca30
        //SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //searchSourceBuilder.query(QueryBuilders.queryStringQuery(searchContent));
        //searchSourceBuilder.field("name");
        //searchSourceBuilder.query(QueryBuilders.matchQuery("name",searchContent));
        //Search search = new Search.Builder(searchSourceBuilder.toString())
          //      .addIndex(T.INDEX_NAME).addType(T.TYPE).build();
        //try {
          //  JestResult result = jestClient.execute(search);
            //return result.getSourceAsObjectList(getParameterClass());
       //} catch (IOException e) {
         //   LOGGER.error(e.getMessage());
           // e.printStackTrace();
       // }
        return null;
    }


    @Override
    public List<T> select(T record) {
        return getMapper().select(record);
    }

    public List<T> select(T record, String orderSqlStr) {
        Example example = new Example(record.getClass(), false);
        Criteria criteria = example.createCriteria();
        Map<String, String> map;
        try {
            map = BeanUtils.describe(record);
            for (Entry<String, String> entry : map.entrySet()) {
                if (entry.getValue() == null || "".equals(entry.getValue())) continue;
                criteria.andEqualTo(entry.getKey(), entry.getValue());
            }
            example.setOrderByClause(orderSqlStr);
            return getMapper().selectByExample(example);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public int selectCount(T record) {
        return getMapper().selectCount(record);
    }

    @Override
    public T selectByPrimaryKey(Object key) {
        return getMapper().selectByPrimaryKey(key);
    }

    @Override
    public int insert(T record) {
        return getMapper().insert(record);
    }

    @Override
    public int insertSelective(T record) {
        return getMapper().insertSelective(record);
    }

    @Override
    public int delete(T key) {
        return getMapper().delete(key);
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return getMapper().updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    /**
     * Utility method. Return parameter class.
     */
    public Class<?> getParameterClass() {
        return (Class<?>) (((ParameterizedType)BaseServiceImpl.class.getGenericSuperclass()).getActualTypeArguments()[0]);
    }


    /*@Override
    public int save(T record) {
        int count = 0;
        if (record.getId() == null) {
            count = this.insertSelective(record);
        } else {
            count = this.updateByPrimaryKeySelective(record);
        }
        return count;
    }*/

    /*
    @Override
    public PageInfo<T> selectPage(int pageNum, int pageSize, T record) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<T>(getMapper().select(record));
    }

    @Override
    public PageInfo<T> selectPage(int pageNum, int pageSize, T record,String orderSqlStr) {
        Example example = new Example(record.getClass(),false);
        Criteria criteriatyUtils.describe(record);
            for(Map.Entry<String, Object> entry : map.entrySet()){
                if(entry.getValue() == null || "".equals(entry.getValue())) continue;
                crite = example.createCriteria();
        Map<String, Object> map;
        try {
            map = Properria.andEqualTo(entry.getKey(), entry.getValue());
            }
            example.setOrderByClause(orderSqlStr);
            PageHelper.startPage(pageNum, pageSize);
            List<T> list = getMapper().selectByExample(example);
            return new PageInfo<T>(list);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    */

}

