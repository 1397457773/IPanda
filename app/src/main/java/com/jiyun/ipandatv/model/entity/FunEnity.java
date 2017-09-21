package com.jiyun.ipandatv.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lenovo on 2017/9/14.
 */
public class FunEnity {

    /**
     * videoset : {"0":{"vsid":"VSET100167216881","relvsid":"","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""},"count":"4909"}
     * video : [{"vsid":"VSET100167216881","order":"4913","vid":"bd38f58a6ad04e749b2c0cd6837102dc","t":"《精彩一刻》 20170913 翻滚吧！煤炭！","url":"http://tv.cntv.cn/video/VSET100167216881/bd38f58a6ad04e749b2c0cd6837102dc","ptime":"2017-09-13 15:29:39","img":"http://p1.img.cctvpic.com/fmspic/2017/09/13/bd38f58a6ad04e749b2c0cd6837102dc-33.jpg?p=2&h=120","len":"00:00:45","em":"CM01"},{"vsid":"VSET100167216881","order":"4912","vid":"846de7dd24f94796ad359f1444b4e180","t":"《精彩一刻》 20170913 谁还不是姐弟咋的？","url":"http://tv.cntv.cn/video/VSET100167216881/846de7dd24f94796ad359f1444b4e180","ptime":"2017-09-13 15:08:00","img":"http://p1.img.cctvpic.com/fmspic/2017/09/13/846de7dd24f94796ad359f1444b4e180-9.jpg?p=2&h=120","len":"00:00:19","em":"CM01"},{"vsid":"VSET100167216881","order":"4914","vid":"d3905ec3f6df4af7a333165b08a50ff4","t":"《精彩一刻》 20170913 看我新创\u201c轮胎舞\u201d","url":"http://tv.cntv.cn/video/VSET100167216881/d3905ec3f6df4af7a333165b08a50ff4","ptime":"2017-09-13 15:04:30","img":"http://p3.img.cctvpic.com/fmspic/2017/09/13/d3905ec3f6df4af7a333165b08a50ff4-22.jpg?p=2&h=120","len":"00:00:36","em":"CM01"},{"vsid":"VSET100167216881","order":"4911","vid":"bca8be2c343445c59221dd1d73770fe8","t":"《精彩一刻》 20170913 小仙女的背影杀~","url":"http://tv.cntv.cn/video/VSET100167216881/bca8be2c343445c59221dd1d73770fe8","ptime":"2017-09-13 15:02:33","img":"http://p5.img.cctvpic.com/fmspic/2017/09/13/bca8be2c343445c59221dd1d73770fe8-9.jpg?p=2&h=120","len":"00:00:19","em":"CM01"},{"vsid":"VSET100167216881","order":"4908","vid":"2d7ad067681a444f91c098b68df0b51a","t":"《精彩一刻》 20170913 你要的礼物到了","url":"http://tv.cntv.cn/video/VSET100167216881/2d7ad067681a444f91c098b68df0b51a","ptime":"2017-09-13 10:30:26","img":"http://p1.img.cctvpic.com/fmspic/2017/09/13/2d7ad067681a444f91c098b68df0b51a-21.jpg?p=2&h=120","len":"00:00:34","em":"CM01"},{"vsid":"VSET100167216881","order":"4909","vid":"f9066270243648de9b85ac397cbe583c","t":"《精彩一刻》 20170913 白袜子小女生\u201c妮娜\u201d","url":"http://tv.cntv.cn/video/VSET100167216881/f9066270243648de9b85ac397cbe583c","ptime":"2017-09-13 10:29:22","img":"http://p4.img.cctvpic.com/fmspic/2017/09/13/f9066270243648de9b85ac397cbe583c-33.jpg?p=2&h=120","len":"00:00:46","em":"CM01"},{"vsid":"VSET100167216881","order":"4910","vid":"77cf6bb8259943c18a9262b93e4c4348","t":"《精彩一刻》 20170913 奶妈教你认幼仔","url":"http://tv.cntv.cn/video/VSET100167216881/77cf6bb8259943c18a9262b93e4c4348","ptime":"2017-09-13 10:28:02","img":"http://p4.img.cctvpic.com/fmspic/2017/09/13/77cf6bb8259943c18a9262b93e4c4348-38.jpg?p=2&h=120","len":"00:00:56","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean {
        /**
         * 0 : {"vsid":"VSET100167216881","relvsid":"","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""}
         * count : 4909
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String count;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean {
            /**
             * vsid : VSET100167216881
             * relvsid :
             * name : 熊猫频道-精彩一刻
             * img : http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100167216881
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl :
             * sbsj : 2013-05-01
             * sbpd : 其他
             * desc : 精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。
             * playdesc :
             * zcr :
             * fcl :
             */

            private String vsid;
            private String relvsid;
            private String name;
            private String img;
            private String enname;
            private String url;
            private String cd;
            private String zy;
            private String bj;
            private String dy;
            private String js;
            private String nf;
            private String yz;
            private String fl;
            private String sbsj;
            private String sbpd;
            private String desc;
            private String playdesc;
            private String zcr;
            private String fcl;

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }
        }
    }

    public static class VideoBean {
        /**
         * vsid : VSET100167216881
         * order : 4913
         * vid : bd38f58a6ad04e749b2c0cd6837102dc
         * t : 《精彩一刻》 20170913 翻滚吧！煤炭！
         * url : http://tv.cntv.cn/video/VSET100167216881/bd38f58a6ad04e749b2c0cd6837102dc
         * ptime : 2017-09-13 15:29:39
         * img : http://p1.img.cctvpic.com/fmspic/2017/09/13/bd38f58a6ad04e749b2c0cd6837102dc-33.jpg?p=2&h=120
         * len : 00:00:45
         * em : CM01
         */

        private String vsid;
        private String order;
        private String vid;
        private String t;
        private String url;
        private String ptime;
        private String img;
        private String len;
        private String em;

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }
    }
}
