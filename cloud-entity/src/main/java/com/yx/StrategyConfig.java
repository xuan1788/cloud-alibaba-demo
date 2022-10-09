package com.yx;

import java.util.List;

/**
 * @author YX_Z
 * @version 1.00
 * @time 2022/9/28 14:14
 *
global:
        sys_path: /Users/yyzhang/Desktop/transmatrix/transmatrix
        project_path: &project_path /Users/yyzhang/Desktop/transmatrix/project_alpha_reasearch
        universe_path: *project_path
        database: sqlite
        matrix: signal #simulation
        tables:
        - ashare_cashflow
        - market_data__stock_cn__bar__1day
        - match_info__stock_cn__bar__1day

        matrix:
        span:
        - 2021-03-01
        - 2021-12-31
        universe:
        costom_universe
        clock:
        - 09:35:00
        match:
        - table: match_info__stock_cn__bar__1day
        - criteria: twap

        strategy:

        strategy1:
        module: strategy.py
        class: TestStrategy
        args:
        - 10
        - 4
        output_dir: factors/strategy1

        strategy2:
        module: strategy.py
        class: TestStrategy
        kwargs:
        pv_periods: 15
        fin_periods: 8
        output_dir: factors/strategy2*/
public class StrategyConfig {
    private String sys_path;
    private String matrix;
    private String project_path;
    private String database;
    private List<String> tables;
}
