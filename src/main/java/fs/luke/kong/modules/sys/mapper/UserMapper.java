package fs.luke.kong.modules.sys.mapper;

import java.util.List;

import fs.luke.kong.core.annotation.MyBatisMapper;
import fs.luke.kong.core.mapper.BaseMapper;
import fs.luke.kong.modules.sys.entity.User;
import org.apache.ibatis.annotations.Select;

@MyBatisMapper
public interface UserMapper extends BaseMapper<User> {
}