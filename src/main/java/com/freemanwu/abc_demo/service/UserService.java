package com.freemanwu.abc_demo.service;

import com.freemanwu.abc_demo.entity.Sheet_Music;
import com.freemanwu.abc_demo.entity.User;
import com.github.pagehelper.PageInfo;

public interface UserService {
    void register(User user);
    User findByNameAndPassword(User user);
    User findByName(User user);
    void update(User user);


    //删除个人曲谱
    void deleteOneMusicUser(Integer id);
    //个人曲谱修改（用户）
    void updateMusicUser(Sheet_Music music);

    //删除某单一曲谱（用户）
    void deleteOneUser(Integer id);
    //批量删除曲谱（用户）
    void deleteListMusic(Integer[] id);

    //按节拍查询曲谱
    PageInfo<Sheet_Music> findMusicByBeat(int pageNo, String beat);

    //按定调查询曲谱
    PageInfo<Sheet_Music> findMusicByTone(int pageNo, String tone);

    //组合查询
    PageInfo<Sheet_Music> CombinedFindMusic(int pageNo, Sheet_Music music);

    //忘记密码
    void forgetPassword(User user);


    //统计A调总数
    Integer totalNumberOfA();

    //统计B调总数
    Integer totalNumberOfB();

    //统计C调总数
    Integer totalNumberOfC();

    //统计D调总数
    Integer totalNumberOfD();

    //统计E调总数
    Integer totalNumberOfE();

    //统计F调总数
    Integer totalNumberOfF();

    //统计G调总数
    Integer totalNumberOfG();

    //统计4/4拍总数
    String totalBeatOf44();

    //统计3/4拍总数
    String totalBeatOf34();

    //统计2/4拍总数
    String totalBeatOf24();

    //统计3/4拍总数
    String totalBeatOf14();
}
