package GoodsApplication.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "商品实体")
public class Goods {

    @ApiModelProperty("商品序号")
    private String id;
    @ApiModelProperty("商品名称")
    private String name;
    @ApiModelProperty("商品单价")
    private double price;



}
