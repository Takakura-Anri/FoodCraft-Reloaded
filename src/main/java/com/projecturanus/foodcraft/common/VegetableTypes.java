package com.projecturanus.foodcraft.common;

import com.projecturanus.foodcraft.common.util.Colorable;
import net.minecraft.potion.PotionEffect;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public enum VegetableTypes implements Colorable {
    /**
     * 茄子
     * Eggplant
     */
    EGGPLANT(new Color(0xc300ff)),

    /**
     * 黄瓜
     * Cucumber
     */
    CUCUMBER(new Color(0x06ad1a)),

    /**
     * 白菜
     * Cabbage
     */
    CABBAGE(new Color(0xe2ffe6)),

    /**
     * 莴苣(生菜)
     * Lettuce
     */
    LETTUCE(new Color(0x98f9a7)),

    /**
     * 蒿子杆
     * Artemisia stalk
     */
    ARTEMISIA_STALK(new Color(0x61f979)),

    /**
     * 菠菜
     * Spinach
     */
    SPINACH(new Color(0x027714)),

    /**
     * 芹菜
     * Celery
     */
    CELERY(new Color(0x15541f)),

    /**
     * 番茄
     * Tomato
     */
    TOMATO(new Color(0xff2121)),

    /**
     * 大米
     * Rice
     */
    RICE(new Color(0xeeeedd)),

    /**
     * 糯米
     * Sticky rice
     */
    STICKY_RICE(new Color(0xffffdd)),

    /**
     * 黑米
     * Black rice
     */
    BLACK_RICE(new Color(0xaaaaaa)),

    /**
     * 玉米
     * Corn
     */
    CORN(new Color(0xffff99)),

    /**
     * 花生
     * Peanut
     */
    PEANUT(new Color(0xeedd00)),

    /**
     * 水萝卜(小萝卜)
     * Radish
     */
    RADISH(new Color(0xff4444)),

    /**
     * 白萝卜
     * White radish
     */
    WHITE_RADISH(new Color(0xffdddd)),

    /**
     * 红椒
     * Red pepper
     */
    RED_PEPPER(new Color(0xFF7F39)),

    /**
     * 青椒
     * Green pepper
     */
    GREEN_PEPPER(new Color(0x75dd09)),

    /**
     * 朝天椒
     * Facing heaven pepper
     */
    FACING_HEAVEN_PEPPER(new Color(0xb21816)),

    /**
     * 胡椒
     * Pepper
     */
    PEPPER(new Color(0x463337)),

    /**
     * 花椒
     * Zanthoxylum
     */
    ZANTHOXYLUM(new Color(0x374832)),

    /**
     * 红薯
     * Sweet potato
     */
    SWEET_POTATO(new Color(0xFFA265)),

    /**
     * 白薯
     * White sweet potato
     */
    WHITE_SWEET_POTATO(new Color(0xFFF3EC)),

    /**
     * 紫薯
     * Purple sweet potato
     */
    PURPLE_SWEET_POTATO(new Color(0xC56C97)),

    /**
     * 芝麻
     * Sesame
     */
    SESAME(new Color(0xFFF973)),

    /**
     * 蒜
     * Garlic
     */
    GARLIC(new Color(0xFBF6FF)),

    /**
     * 姜
     * Ginger
     */
    GINGER(new Color(0xDBB121)),

    /**
     * 洋葱
     * Onion
     */
    ONION(new Color(0xDCD8AE)),

    /**
     * 葱
     * Green onion
     */
    GREEN_ONION(new Color(0x84F941));

    private Color color;
    private List<PotionEffect> effects;

    VegetableTypes(Color color) {
        this.color = color;
    }

    VegetableTypes(Color color, PotionEffect... effects) {
        this(color);
        this.effects = Arrays.asList(effects);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }

    public List<PotionEffect> getEffects() {
        return effects;
    }
}
