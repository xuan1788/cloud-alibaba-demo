package cn.cloud.market.mp.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YX_Z
 * @version 1.00
 * @time 2022/9/27 16:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("items")
public class Stock {

/*
            code   # 股票代码
            abbr # 股票简称
            last_trade # 最新价
            chg_ratio # 涨跌幅
            chg_amt # 涨跌额
            chg_ratio_5min # 5分钟涨幅
            volumn # 成交量
            turn_over # 成交额
            */

    @TableId("code")
    private String code;

    @TableField("abbr")
    private String abbr;

    @TableField("last_trade")
    private double last_trade;

    @TableField("chg_ratio")
    private double chg_ratio;

    @TableField("chg_amt")
    private double chg_amt;

    @TableField("chg_ratio_5min")
    private double chg_ratio_5min;

/*    private double volume;

    private double turn_over;*/
}
