package com.hejian.mobile.client.mapper;

import com.hejian.mobile.client.model.domain.GroupDO;

public interface GroupDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GroupDO record);

    int insertSelective(GroupDO record);

    GroupDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupDO record);

    int updateByPrimaryKey(GroupDO record);
}