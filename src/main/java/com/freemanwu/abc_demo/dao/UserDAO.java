package com.freemanwu.abc_demo.dao;

import com.freemanwu.abc_demo.entity.Favorite;
import com.freemanwu.abc_demo.entity.Sheet_Music;
import com.freemanwu.abc_demo.entity.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@CacheNamespace
@Mapper
public interface UserDAO {
    //用户注册
    void register(User user);

    //用户登陆
    User findByNameAndPassword(User user);

    //用户主页
    User findByName(User user);

    //用户更新信息
    void update(User user);
//——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
    //个人曲谱查询（用户）
    Sheet_Music findMusicByUserName(Sheet_Music music);

    //删除个人曲谱
    void deleteOneMusicUser(Integer id);

    //个人曲谱修改（用户）
    void updateMusicUser(Sheet_Music music);

    //删除某单一曲谱（用户）
    void deleteOneUser(Integer id);

    //批量删除曲谱（用户）
    void deleteListMusic(Integer[] id);

    //按节拍查询曲谱
    List<Sheet_Music> findMusicByBeat(String beat);

    //按定调查询曲谱
    List<Sheet_Music> findMusicByTone(String tone);

    //组合查询
    List<Sheet_Music> CombinedFindMusic(Sheet_Music music);

    //忘记密码
    void forgetPassword(User user);


    //统计A调总数
    Integer totalNumberOfA();
    Integer totalNumberOfUpA();
    Integer totalNumberOfbA();

    //统计B调总数
    Integer totalNumberOfB();
    Integer totalNumberOfUpB();
    Integer totalNumberOfbB();

    //统计C调总数
    Integer totalNumberOfC();
    Integer totalNumberOfUpC();
    Integer totalNumberOfbC();

    //统计D调总数
    Integer totalNumberOfD();
    Integer totalNumberOfUpD();
    Integer totalNumberOfbD();

    //统计E调总数
    Integer totalNumberOfE();
    Integer totalNumberOfUpE();
    Integer totalNumberOfbE();

    //统计F调总数
    Integer totalNumberOfF();
    Integer totalNumberOfUpF();
    Integer totalNumberOfbF();

    //统计G调总数
    Integer totalNumberOfG();
    Integer totalNumberOfUpG();
    Integer totalNumberOfbG();

    //统计4/4拍总数
    String totalBeatOf44();

    //统计3/4拍总数
    String totalBeatOf34();

    //统计2/4拍总数
    String totalBeatOf24();

    //统计3/4拍总数
    String totalBeatOf14();

    //统计3/8拍总数
    String totalBeatOf38();

    //统计6/8拍总数
    String totalBeatOf68();

    //注销账号
    void deleteAccount(String username);
    void UnNamedMusic(String username);

    //查重用户名
    Integer checkUserName(String username);

    //收藏曲谱
    void insertFavorite(Favorite favorite);

    //查看收藏曲谱
    List<Sheet_Music> showFavorite(String username);

    //删除单个收藏
    void deleteOneCollection(Integer music_id, String username);

    //批量删除收藏
    void deleteListCollection(@Param(value = "music_id")Integer[] music_id,  @Param(value = "username")String username);
}
