package cn.cloud.market;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YX_Z
 * @version 1.00
 * @time 2022/9/20 13:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private String goodsName;
    private double price;
}
