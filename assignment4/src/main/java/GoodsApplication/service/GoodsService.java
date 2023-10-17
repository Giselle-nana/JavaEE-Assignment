package GoodsApplication.service;

import GoodsApplication.entity.Goods;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GoodsService {

    private Map<String,Goods> goods = new HashMap<String,Goods>();

    //总金额
    private double sum;

    public GoodsService(){
        sum=0;
    }
    public GoodsService(Map<String,Goods>goods)
    {
        this.goods=goods;
       for(Map.Entry<String, Goods> entry:goods.entrySet())
       {
           sum+=entry.getValue().getPrice();
       }
    }

    public Goods AddGood(Goods good)
    {
        goods.put(good.getId(),good);
        sum+=good.getPrice();
        return good;
    }

    public void DeleteGood(String id)
    {
       goods.remove(id);


    }

    public Goods ModifyGoods(String id,Goods g)
    {
        Goods good = QueryById(id);
        if(good==null)
        {
            return null;
        }
        good.setPrice(g.getPrice());
        good.setName(g.getName());
        goods.put(id,good);
        return good;


    }

    public Goods QueryById(String id)
    {
        for(Map.Entry<String,Goods>entry:goods.entrySet())
        {
            if(entry.getValue().getId().equals(id))
            {
                return entry.getValue();
            }
        }
        return null;
    }

    public Collection<Goods> QueryAll()
    {
        return goods.values();
    }
}
