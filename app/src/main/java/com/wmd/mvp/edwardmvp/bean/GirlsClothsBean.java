package com.wmd.mvp.edwardmvp.bean;

/**
 * 时间：2017/11/18/13：18
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：淘宝女装类
 * 声明：版权归作者所有
 */

public class GirlsClothsBean {
    private int Image;

    public GirlsClothsBean(int image, String leble) {
        Image = image;
        this.leble = leble;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getLeble() {
        return leble;
    }

    public void setLeble(String leble) {
        this.leble = leble;
    }

    private String leble;
}
