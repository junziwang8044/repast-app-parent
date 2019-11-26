package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.DeleteHistorySearch;
import tk.mybatis.mapper.common.Mapper;

public interface DeleteHistorySearchMapper extends Mapper<DeleteHistorySearch> {
   int deleteHistorySearch(Long id);
}