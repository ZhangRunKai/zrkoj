package com.zrk.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrk.entity.Label;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/16 12:17
 */
public interface LabelServlet {
    public Integer add(Label label);

    public Integer delete(Label label);

    public Integer update(Label label);

    public IPage<Label> findAll(Page<Label> page);
}
