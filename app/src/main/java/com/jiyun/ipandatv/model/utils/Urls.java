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

    //熊猫直播
    public static final String FOURLIVE="http://www.ipanda.com/kehuduan/PAGE14501769230331752/index.json";
    //精彩一刻
    public static final String FOUTFUN ="http://api.cntv.cn/video/videolistById?vsid=VSET100167216881&n=7&serviceId=panda&o=desc&of=time&p=1";

    //超萌滚滚秀
    public static final String FOUROUT= "http://api.cntv.cn/video/videolistById?vsid=VSET100272959126&n=7&serviceId=panda&o=desc&of=time&p=1";

    //熊猫档案
    public static final String FOURBOOK= "http://api.cntv.cn/video/videolistById?vsid=VSET100340574858&n=7&serviceId=panda&o=desc&of=time&p=1";

    //熊猫Top榜
    public static final String FOURTOP ="http://api.cntv.cn/video/videolistById?vsid=VSET100284428835&n=7&serviceId=panda&o=desc&of=time&p=1";

    //熊猫那些事儿
    public static final String FOURTHING= "http://api.cntv.cn/video/videolistById?vsid=VSET100237714751&n=7&serviceId=panda&o=desc&of=time&p=1";

    //特别节目
    public static final String FOURSPECIAL ="http://api.cntv.cn/video/videolistById?vsid=VSET100167308855&n=7&serviceId=panda&o=desc&of=time&p=1";

    //原创新闻
    public static final String FOURNEW = "http://api.cntv.cn/video/videolistById?vsid=VSET100219009515&n=7&serviceId=panda&o=desc&of=time&p=1";

}
