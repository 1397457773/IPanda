package com.jiyun.ipandatv.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 王云飞 on 2017/9/21.
 */
public class Home_Video1 {

    /**
     * play_channel :
     * f_pgmtime : 2011-05-11 18:48:36
     * tag :
     * cdn_info : {"cdn_vip":"cntv.vod.cdn.myqcloud.com","cdn_code":"VOD-MP4-CDN-QQ","cdn_name":"3rd腾讯云"}
     * editer_name :
     * version : 0.2
     * title : 国宝档案 神面卣 2
     * is_fn_hot : false
     * is_protected : 0
     * hls_url : http://asp.cntv.lxdns.com/asp/hls/main/0303000a/3/default/fcfbdc3a79c5469b8b730d999f872cd4/main.m3u8?maxbr=4096
     * hls_cdn_info : {"cdn_vip":"asp.cntv.lxdns.com","cdn_code":"VOD-HLS-CDN-CNC","cdn_name":"3rd网宿"}
     * client_sid : a8d7a338b5874e4582e59bf2cd17c272
     * is_ipad_support : true
     * video : {"totalLength":"405.00","chapters":[{"duration":"293","image":"http://p5.img.cctvpic.com/fmspic/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4-180.jpg","url":"http://cntv.vod.cdn.myqcloud.com/flash/mp4video10/TMS/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4_h264418000nero_aac32-1.mp4"},{"duration":"112","image":"http://p5.img.cctvpic.com/fmspic/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4-180.jpg","url":"http://cntv.vod.cdn.myqcloud.com/flash/mp4video10/TMS/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4_h264418000nero_aac32-2.mp4"}],"validChapterNum":2,"chapters2":[{"duration":"176","image":"http://p5.img.cctvpic.com/fmspic/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4-180.jpg","url":"http://cntv.vod.cdn.myqcloud.com/flash/mp4video10/TMS/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4_h264818000nero_aac32-1.mp4"},{"duration":"180","image":"http://p5.img.cctvpic.com/fmspic/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4-180.jpg","url":"http://cntv.vod.cdn.myqcloud.com/flash/mp4video10/TMS/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4_h264818000nero_aac32-2.mp4"},{"duration":"49","image":"http://p5.img.cctvpic.com/fmspic/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4-180.jpg","url":"http://cntv.vod.cdn.myqcloud.com/flash/mp4video10/TMS/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4_h264818000nero_aac32-3.mp4"}],"url":""}
     * is_invalid_copyright : 0
     * produce_id :
     * default_stream : HD
     * ack : yes
     * is_fn_multi_stream : false
     * embed :
     * asp_error_code : 0
     * column : 国宝档案
     * lc : {"isp_code":"1","city_code":"","provice_code":"BJ","country_code":"CN","ip":"182.18.115.127"}
     * public : 1
     * is_p2p_use : false
     * produce :
     */

    private String play_channel;
    private String f_pgmtime;
    private String tag;
    private CdnInfoBean cdn_info;
    private String editer_name;
    private String version;
    private String title;
    private String is_fn_hot;
    private String is_protected;
    private String hls_url;
    private HlsCdnInfoBean hls_cdn_info;
    private String client_sid;
    private String is_ipad_support;
    private VideoBean video;
    private String is_invalid_copyright;
    private String produce_id;
    private String default_stream;
    private String ack;
    private boolean is_fn_multi_stream;
    private String embed;
    private int asp_error_code;
    private String column;
    private LcBean lc;
    @SerializedName("public")
    private String publicX;
    private boolean is_p2p_use;
    private String produce;

    public String getPlay_channel() {
        return play_channel;
    }

    public void setPlay_channel(String play_channel) {
        this.play_channel = play_channel;
    }

    public String getF_pgmtime() {
        return f_pgmtime;
    }

    public void setF_pgmtime(String f_pgmtime) {
        this.f_pgmtime = f_pgmtime;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public CdnInfoBean getCdn_info() {
        return cdn_info;
    }

    public void setCdn_info(CdnInfoBean cdn_info) {
        this.cdn_info = cdn_info;
    }

    public String getEditer_name() {
        return editer_name;
    }

    public void setEditer_name(String editer_name) {
        this.editer_name = editer_name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIs_fn_hot() {
        return is_fn_hot;
    }

    public void setIs_fn_hot(String is_fn_hot) {
        this.is_fn_hot = is_fn_hot;
    }

    public String getIs_protected() {
        return is_protected;
    }

    public void setIs_protected(String is_protected) {
        this.is_protected = is_protected;
    }

    public String getHls_url() {
        return hls_url;
    }

    public void setHls_url(String hls_url) {
        this.hls_url = hls_url;
    }

    public HlsCdnInfoBean getHls_cdn_info() {
        return hls_cdn_info;
    }

    public void setHls_cdn_info(HlsCdnInfoBean hls_cdn_info) {
        this.hls_cdn_info = hls_cdn_info;
    }

    public String getClient_sid() {
        return client_sid;
    }

    public void setClient_sid(String client_sid) {
        this.client_sid = client_sid;
    }

    public String getIs_ipad_support() {
        return is_ipad_support;
    }

    public void setIs_ipad_support(String is_ipad_support) {
        this.is_ipad_support = is_ipad_support;
    }

    public VideoBean getVideo() {
        return video;
    }

    public void setVideo(VideoBean video) {
        this.video = video;
    }

    public String getIs_invalid_copyright() {
        return is_invalid_copyright;
    }

    public void setIs_invalid_copyright(String is_invalid_copyright) {
        this.is_invalid_copyright = is_invalid_copyright;
    }

    public String getProduce_id() {
        return produce_id;
    }

    public void setProduce_id(String produce_id) {
        this.produce_id = produce_id;
    }

    public String getDefault_stream() {
        return default_stream;
    }

    public void setDefault_stream(String default_stream) {
        this.default_stream = default_stream;
    }

    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }

    public boolean isIs_fn_multi_stream() {
        return is_fn_multi_stream;
    }

    public void setIs_fn_multi_stream(boolean is_fn_multi_stream) {
        this.is_fn_multi_stream = is_fn_multi_stream;
    }

    public String getEmbed() {
        return embed;
    }

    public void setEmbed(String embed) {
        this.embed = embed;
    }

    public int getAsp_error_code() {
        return asp_error_code;
    }

    public void setAsp_error_code(int asp_error_code) {
        this.asp_error_code = asp_error_code;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public LcBean getLc() {
        return lc;
    }

    public void setLc(LcBean lc) {
        this.lc = lc;
    }

    public String getPublicX() {
        return publicX;
    }

    public void setPublicX(String publicX) {
        this.publicX = publicX;
    }

    public boolean isIs_p2p_use() {
        return is_p2p_use;
    }

    public void setIs_p2p_use(boolean is_p2p_use) {
        this.is_p2p_use = is_p2p_use;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }

    public static class CdnInfoBean {
        /**
         * cdn_vip : cntv.vod.cdn.myqcloud.com
         * cdn_code : VOD-MP4-CDN-QQ
         * cdn_name : 3rd腾讯云
         */

        private String cdn_vip;
        private String cdn_code;
        private String cdn_name;

        public String getCdn_vip() {
            return cdn_vip;
        }

        public void setCdn_vip(String cdn_vip) {
            this.cdn_vip = cdn_vip;
        }

        public String getCdn_code() {
            return cdn_code;
        }

        public void setCdn_code(String cdn_code) {
            this.cdn_code = cdn_code;
        }

        public String getCdn_name() {
            return cdn_name;
        }

        public void setCdn_name(String cdn_name) {
            this.cdn_name = cdn_name;
        }
    }

    public static class HlsCdnInfoBean {
        /**
         * cdn_vip : asp.cntv.lxdns.com
         * cdn_code : VOD-HLS-CDN-CNC
         * cdn_name : 3rd网宿
         */

        private String cdn_vip;
        private String cdn_code;
        private String cdn_name;

        public String getCdn_vip() {
            return cdn_vip;
        }

        public void setCdn_vip(String cdn_vip) {
            this.cdn_vip = cdn_vip;
        }

        public String getCdn_code() {
            return cdn_code;
        }

        public void setCdn_code(String cdn_code) {
            this.cdn_code = cdn_code;
        }

        public String getCdn_name() {
            return cdn_name;
        }

        public void setCdn_name(String cdn_name) {
            this.cdn_name = cdn_name;
        }
    }

    public static class VideoBean {
        /**
         * totalLength : 405.00
         * chapters : [{"duration":"293","image":"http://p5.img.cctvpic.com/fmspic/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4-180.jpg","url":"http://cntv.vod.cdn.myqcloud.com/flash/mp4video10/TMS/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4_h264418000nero_aac32-1.mp4"},{"duration":"112","image":"http://p5.img.cctvpic.com/fmspic/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4-180.jpg","url":"http://cntv.vod.cdn.myqcloud.com/flash/mp4video10/TMS/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4_h264418000nero_aac32-2.mp4"}]
         * validChapterNum : 2
         * chapters2 : [{"duration":"176","image":"http://p5.img.cctvpic.com/fmspic/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4-180.jpg","url":"http://cntv.vod.cdn.myqcloud.com/flash/mp4video10/TMS/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4_h264818000nero_aac32-1.mp4"},{"duration":"180","image":"http://p5.img.cctvpic.com/fmspic/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4-180.jpg","url":"http://cntv.vod.cdn.myqcloud.com/flash/mp4video10/TMS/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4_h264818000nero_aac32-2.mp4"},{"duration":"49","image":"http://p5.img.cctvpic.com/fmspic/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4-180.jpg","url":"http://cntv.vod.cdn.myqcloud.com/flash/mp4video10/TMS/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4_h264818000nero_aac32-3.mp4"}]
         * url :
         */

        private String totalLength;
        private int validChapterNum;
        private String url;
        private List<ChaptersBean> chapters;
        private List<Chapters2Bean> chapters2;

        public String getTotalLength() {
            return totalLength;
        }

        public void setTotalLength(String totalLength) {
            this.totalLength = totalLength;
        }

        public int getValidChapterNum() {
            return validChapterNum;
        }

        public void setValidChapterNum(int validChapterNum) {
            this.validChapterNum = validChapterNum;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<ChaptersBean> getChapters() {
            return chapters;
        }

        public void setChapters(List<ChaptersBean> chapters) {
            this.chapters = chapters;
        }

        public List<Chapters2Bean> getChapters2() {
            return chapters2;
        }

        public void setChapters2(List<Chapters2Bean> chapters2) {
            this.chapters2 = chapters2;
        }

        public static class ChaptersBean {
            /**
             * duration : 293
             * image : http://p5.img.cctvpic.com/fmspic/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4-180.jpg
             * url : http://cntv.vod.cdn.myqcloud.com/flash/mp4video10/TMS/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4_h264418000nero_aac32-1.mp4
             */

            private String duration;
            private String image;
            private String url;

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class Chapters2Bean {
            /**
             * duration : 176
             * image : http://p5.img.cctvpic.com/fmspic/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4-180.jpg
             * url : http://cntv.vod.cdn.myqcloud.com/flash/mp4video10/TMS/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4_h264818000nero_aac32-1.mp4
             */

            private String duration;
            private String image;
            private String url;

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

    public static class LcBean {
        /**
         * isp_code : 1
         * city_code :
         * provice_code : BJ
         * country_code : CN
         * ip : 182.18.115.127
         */

        private String isp_code;
        private String city_code;
        private String provice_code;
        private String country_code;
        private String ip;

        public String getIsp_code() {
            return isp_code;
        }

        public void setIsp_code(String isp_code) {
            this.isp_code = isp_code;
        }

        public String getCity_code() {
            return city_code;
        }

        public void setCity_code(String city_code) {
            this.city_code = city_code;
        }

        public String getProvice_code() {
            return provice_code;
        }

        public void setProvice_code(String provice_code) {
            this.provice_code = provice_code;
        }

        public String getCountry_code() {
            return country_code;
        }

        public void setCountry_code(String country_code) {
            this.country_code = country_code;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }
    }
}