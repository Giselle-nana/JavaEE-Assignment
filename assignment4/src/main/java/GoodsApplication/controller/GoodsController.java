package GoodsApplication.controller;
import GoodsApplication.entity.Goods;
import GoodsApplication.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;

@Api(tags = "商品管理")
@RestController
@RequestMapping("goods")
public class GoodsController {


@Autowired
GoodsService goodsService;

    @ApiOperation("根据ID查询商品")
    @GetMapping("/{id}")
    public ResponseEntity<Goods> getGoods(@ApiParam("商品Id")@PathVariable String id)
    {
        Goods goods= goodsService.QueryById(id);
        if(goods==null)
        {
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(goods);
        }
    }

    @ApiOperation("增加商品")
    @PostMapping("/add")
    public ResponseEntity<Goods> AddGoods(@RequestBody Goods goods)
    {
        Goods result=goodsService.AddGood(goods);
        return ResponseEntity.ok(goods);

    }

    @ApiOperation("删除商品")
    @DeleteMapping("/delete/{id}")
    public void DeleteGoods(@ApiParam("商品Id")@PathVariable String id)
    {
        goodsService.DeleteGood(id);
    }

    @ApiOperation("修改商品")
    @PutMapping("/modify/{id}")
    public ResponseEntity<Goods> ModifyGoods(@PathVariable String id,@RequestBody Goods goods)
    {
        Goods goods1= goodsService.ModifyGoods(id,goods);
        if(goods1==null)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(goods1);

    }

    @ApiOperation("查询所有商品")
    @GetMapping("query")
    public ResponseEntity<Collection<Goods>> QueryById()
    {
        return ResponseEntity.ok(goodsService.QueryAll());
    }

}
