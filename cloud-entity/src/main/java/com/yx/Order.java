package com.yx;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YX_Z
 * @version 1.00
 * @time 2022/9/22 10:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    /*
        factor_name,
        periods: int = None,
        shift: timedelta = None,
        window : timedelta = None
    */
    private Integer uid;
    private Integer num;
    
    private String type;
}
