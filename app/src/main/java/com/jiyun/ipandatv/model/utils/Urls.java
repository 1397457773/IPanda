package com.jiyun.ipandatv.model.utils;

/**
 * Created by Administrator on 2017/8/23 0023.
 */

public class Urls {
    //服务器地址
    private static final String BASEURL = "http://www.ipanda.com/kehuduan/";

    //首页
    public static final String PANDAHOME = BASEURL+"PAGE14501749764071042/index.json";
    //首页互动
    public static final String HUDONG=BASEURL+"PAGE14501767715521482/index.json";
    //熊猫直播
    public static final String PANDALIVE = BASEURL+"PAGE14501769230331752/index.json";
    //    熊猫直播tablayout标题
    public static final String PANDALIVETAB = BASEURL+"PAGE14501772263221982/index.json";
    //列表
    public static final String PAGELIST = BASEURL+"PAGE14501786751053212/index.json";

    //获取图片验证码
    public static final String IMGCODE = "http://reg.cntv.cn/simple/verificationCode.action";
    //邮箱注册
    public static final String EMAILREGISTER = "https://reg.cntv.cn/api/register.action";

    //熊猫文化
    public static final String PANDACULTURE=BASEURL+"xmwh/index.json";

    //熊猫播报 （温）
    public static final String PANDABROADCAST="http://www.ipanda.com/kehuduan/PAGE14503485387528442/index.json";

    public static final String PANDABROADCAST2="http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1449807494852603,PAGE1451473625420136,PAGE1449807502866458,PAGE1451473627439140,PAGE1451473547108278,PAGE1451473628934144&serviceId=panda";
    //直播中国
    public static final String LIVECHINA=BASEURL+"PAGE14501775094142282/index.json";
    //    熊猫直播 其他 fragment
    public static final String BASEOTHERFragment = "http://api.cntv.cn/video/videolistById";
    //  单视频 播放
    public static final String PANDAVOD = "http://vdn.apps.cntv.cn/api/getVideoInfoForCBox.do";
    //    熊猫直播 多视角直播
    public static final String PANDALIVEMULTI = BASEURL+"PAGE14501769230331752/PAGE14501787896813312/index.json";
    //所有的播放视频的地址
    public static final String PLAYVIDEO="http://vdn.apps.cntv.cn/api/getVideoInfoForCBox.do";

    //登录
    public static String FORM = "https://reg.cntv.cn/login/login.action";

    //获取昵称
    public static String GETNiCkNAME="http://my.cntv.cn/intf/napi/api.php";

    //手机号验证码注册
    public static String PHONEYANZHENG = "http://reg.cntv.cn/regist/getVerifiCode.action";

    //手机号注册
    public static String PHONEREGISTER="https://reg.cntv.cn/regist/mobileRegist.do";
    //版本更新
    public static final String VERSION="http://115.182.9.124/index.php?action=release-GetNewVersions&applyName=1426217325";

    //熊猫播报视频播放
    public static final String VIDEOPLAY="http://115.182.35.91/api/getVideoInfoForCBox.do?pid=";

    public static final String SHANGLAURL = "http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1449807494852603,PAGE1451473625420136,PAGE1449807502866458,PAGE1451473627439140,PAGE1451473547108278,PAGE1451473628934144&serviceId=panda&pageSize=6&page=5";
    public static final String SHANGLAURL1 = "http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1449807494852603,PAGE1451473625420136,PAGE1449807502866458,PAGE1451473627439140,PAGE1451473547108278,PAGE1451473628934144&serviceId=panda&pageSize=6&page=6";
    public static final String SHANGLAURL2 = "http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1449807494852603,PAGE1451473625420136,PAGE1449807502866458,PAGE1451473627439140,PAGE1451473547108278,PAGE1451473628934144&serviceId=panda&pageSize=6&page=7";
    public static final String SHANGLAURL3 = "http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1449807494852603,PAGE1451473625420136,PAGE1449807502866458,PAGE1451473627439140,PAGE1451473547108278,PAGE1451473628934144&serviceId=panda&pageSize=6&page=8";
    public static final String SHANGLAURL4 = "http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1449807494852603,PAGE1451473625420136,PAGE1449807502866458,PAGE1451473627439140,PAGE1451473547108278,PAGE1451473628934144&serviceId=panda&pageSize=6&page=9";
    public static final String SHANGLAURL5 = "http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1449807494852603,PAGE1451473625420136,PAGE1449807502866458,PAGE1451473627439140,PAGE1451473547108278,PAGE1451473628934144&serviceId=panda&pageSize=6&page=10";

    //国宝档案 高清完整
    public static final String NEH1="http://api.cntv.cn/video/videolistById?n=6&vsid=C14121&p=1&serviceId=panda&em=1";
    public static final String NEH2="http://api.cntv.cn/video/videolistById?n=6&vsid=C14121&p=2&serviceId=panda&em=1";
    public static final String NEH3="http://api.cntv.cn/video/videolistById?n=6&vsid=C14121&p=3&serviceId=panda&em=1";
    public static final String NEH4="http://api.cntv.cn/video/videolistById?n=6&vsid=C14121&p=4&serviceId=panda&em=1";

    //国宝档案 精彩看点
    public static final String N1="http://api.cntv.cn/video/videolistById?n=6&vsid=C14121&p=1&serviceId=panda&em=2";
    public static final String N2="http://api.cntv.cn/video/videolistById?n=6&vsid=C14121&p=2&serviceId=panda&em=2";
    public static final String N3="http://api.cntv.cn/video/videolistById?n=6&vsid=C14121&p=3&serviceId=panda&em=2";
    public static final String N4="http://api.cntv.cn/video/videolistById?n=6&vsid=C14121&p=4&serviceId=panda&em=2";

    //走遍中国  高清完整
    public static final String CHINA1="http://api.cntv.cn/video/videolistById?n=6&vsid=C10352&p=1&serviceId=panda&em=1";
    public static final String CHINA2="http://api.cntv.cn/video/videolistById?n=6&vsid=C10352&p=2&serviceId=panda&em=1";
    public static final String CHINA3="http://api.cntv.cn/video/videolistById?n=6&vsid=C10352&p=3&serviceId=panda&em=1";
    public static final String CHINA4="http://api.cntv.cn/video/videolistById?n=6&vsid=C10352&p=4&serviceId=panda&em=1";

    //走遍中国 精彩看点
    public static final String C1="http://api.cntv.cn/video/videolistById?n=6&vsid=C10352&p=1&serviceId=panda&em=2";
    public static final String C2="http://api.cntv.cn/video/videolistById?n=6&vsid=C10352&p=2&serviceId=panda&em=2";
    public static final String C3="http://api.cntv.cn/video/videolistById?n=6&vsid=C10352&p=3&serviceId=panda&em=2";
    public static final String C4="http://api.cntv.cn/video/videolistById?n=6&vsid=C10352&p=4&serviceId=panda&em=2";

    //华人世界 高清完整
    public static final String HPER1="http://api.cntv.cn/video/videolistById?n=6&vsid=C17604&p=1&serviceId=panda&em=1";
    public static final String HPER2="http://api.cntv.cn/video/videolistById?n=6&vsid=C17604&p=2&serviceId=panda&em=1";
    public static final String HPER3="http://api.cntv.cn/video/videolistById?n=6&vsid=C17604&p=3&serviceId=panda&em=1";
    public static final String HPER4="http://api.cntv.cn/video/videolistById?n=6&vsid=C17604&p=4&serviceId=panda&em=1";

    //华人世界 精彩看点
    public static final String H1="http://api.cntv.cn/video/videolistById?n=6&vsid=C17604&p=1&serviceId=panda&em=2";
    public static final String H2="http://api.cntv.cn/video/videolistById?n=6&vsid=C17604&p=2&serviceId=panda&em=2";
    public static final String H3="http://api.cntv.cn/video/videolistById?n=6&vsid=C17604&p=3&serviceId=panda&em=2";
    public static final String H4="http://api.cntv.cn/video/videolistById?n=6&vsid=C17604&p=4&serviceId=panda&em=2";

    //中国文艺
    public static final String ZW1="http://api.cntv.cn/video/videolistById?n=6&vsid=C10471&p=1&serviceId=panda&em=1";
    public static final String ZW2="http://api.cntv.cn/video/videolistById?n=6&vsid=C10471&p=2&serviceId=panda&em=1";
    public static final String ZW3="http://api.cntv.cn/video/videolistById?n=6&vsid=C10471&p=3&serviceId=panda&em=1";
    public static final String ZW4="http://api.cntv.cn/video/videolistById?n=6&vsid=C10471&p=4&serviceId=panda&em=1";

    //中国文艺 精彩看点
    public static final String Z1="http://api.cntv.cn/video/videolistById?n=6&vsid=C10471&p=1&serviceId=panda&em=2";
    public static final String Z2="http://api.cntv.cn/video/videolistById?n=6&vsid=C10471&p=2&serviceId=panda&em=2";
    public static final String Z3="http://api.cntv.cn/video/videolistById?n=6&vsid=C10471&p=3&serviceId=panda&em=2";
    public static final String Z4="http://api.cntv.cn/video/videolistById?n=6&vsid=C10471&p=4&serviceId=panda&em=2";
}
