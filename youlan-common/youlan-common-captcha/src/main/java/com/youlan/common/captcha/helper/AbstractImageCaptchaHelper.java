package com.youlan.common.captcha.helper;

import cn.hutool.captcha.AbstractCaptcha;
import cn.hutool.captcha.generator.CodeGenerator;
import cn.hutool.captcha.generator.MathGenerator;
import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.core.math.Calculator;
import cn.hutool.core.util.RandomUtil;
import com.youlan.common.captcha.entity.CaptchaContext;
import com.youlan.common.captcha.entity.CaptchaInfo;
import com.youlan.common.captcha.entity.ImageCaptcha;
import com.youlan.common.captcha.enums.CaptchaCodeType;

public abstract class AbstractImageCaptchaHelper extends CaptchaHelper {

    /**
     * 生成验证码
     *
     * @param captchaCodeType 验证码内容类型
     * @param context         验证码配置上下文
     * @return 验证码信息
     */
    public ImageCaptcha createCaptcha(CaptchaCodeType captchaCodeType, CaptchaContext context) {
        switch (captchaCodeType) {
            case CHAR:
                return createCharCaptcha(context);
            case NUMBER:
                return createNumberCaptcha(context);
            case CHAR_NUMBER:
                return createCharNumberCaptcha(context);
            case MATH:
            default:
                return createMatchCaptcha(context);
        }
    }

    /**
     * 生成仅包含char的验证码
     *
     * @return 验证码信息
     */
    public ImageCaptcha createCharCaptcha() {
        CaptchaContext context = new CaptchaContext();
        return createCaptcha(context, new RandomGenerator(RandomUtil.BASE_CHAR, context.getCodeLength()));
    }

    /**
     * 生成仅包含char的验证码
     *
     * @param context 验证码配置上下文
     * @return 验证码信息
     */
    public ImageCaptcha createCharCaptcha(CaptchaContext context) {
        return createCaptcha(context, new RandomGenerator(RandomUtil.BASE_CHAR, context.getCodeLength()));
    }

    /**
     * 生成仅包含char的验证码
     *
     * @param uniqueId 限流唯一ID
     * @param context  验证码配置上下文
     * @return 验证码信息
     */
    public ImageCaptcha createCharCaptcha(String uniqueId, CaptchaContext context) {
        context.setSourceId(uniqueId);
        return createCaptcha(context, new RandomGenerator(RandomUtil.BASE_CHAR, context.getCodeLength()));
    }

    /**
     * 生成仅包含char的验证码
     *
     * @param uniqueId 限流唯一ID
     * @return 验证码信息
     */
    public ImageCaptcha createCharCaptcha(String uniqueId) {
        CaptchaContext context = new CaptchaContext();
        context.setSourceId(uniqueId);
        return createCaptcha(context, new RandomGenerator(RandomUtil.BASE_CHAR, context.getCodeLength()));
    }

    /**
     * 生成仅包含char的验证码
     *
     * @param uniqueId  限流唯一ID
     * @param codeLimit 超时时间内最大生成次数
     * @param context   验证码配置上下文
     * @return 验证码信息
     */
    public ImageCaptcha createCharCaptcha(String uniqueId, int codeLimit, CaptchaContext context) {
        context.setSourceId(uniqueId)
                .setCodeLimit(codeLimit);
        return createCaptcha(context, new RandomGenerator(RandomUtil.BASE_CHAR, context.getCodeLength()));
    }

    /**
     * 生成仅包含char的验证码
     *
     * @param uniqueId  限流唯一ID
     * @param codeLimit 超时时间内最大生成次数
     * @return 验证码信息
     */
    public ImageCaptcha createCharCaptcha(String uniqueId, int codeLimit) {
        CaptchaContext context = new CaptchaContext();
        context.setSourceId(uniqueId)
                .setCodeLimit(codeLimit);
        return createCaptcha(context, new RandomGenerator(RandomUtil.BASE_CHAR, context.getCodeLength()));
    }

    /**
     * 生成仅包含数字的验证码
     *
     * @return 验证码信息
     */
    public ImageCaptcha createNumberCaptcha() {
        CaptchaContext context = new CaptchaContext();
        return createCaptcha(context, new RandomGenerator(RandomUtil.BASE_NUMBER, context.getCodeLength()));
    }

    /**
     * 生成仅包含数字的验证码
     *
     * @param context 验证码配置上下文
     * @return 验证码信息
     */
    public ImageCaptcha createNumberCaptcha(CaptchaContext context) {
        return createCaptcha(context, new RandomGenerator(RandomUtil.BASE_NUMBER, context.getCodeLength()));
    }

    /**
     * 生成仅包含数字的验证码
     *
     * @param uniqueId 限流唯一ID
     * @param context  验证码配置上下文
     * @return 验证码信息
     */
    public ImageCaptcha createNumberCaptcha(String uniqueId, CaptchaContext context) {
        context.setSourceId(uniqueId);
        return createCaptcha(context, new RandomGenerator(RandomUtil.BASE_NUMBER, context.getCodeLength()));
    }

    /**
     * 生成仅包含数字的验证码
     *
     * @param uniqueId 限流唯一ID
     * @return 验证码信息
     */
    public ImageCaptcha createNumberCaptcha(String uniqueId) {
        CaptchaContext context = new CaptchaContext();
        context.setSourceId(uniqueId);
        return createCaptcha(context, new RandomGenerator(RandomUtil.BASE_NUMBER, context.getCodeLength()));
    }

    /**
     * 生成仅包含数字的验证码
     *
     * @param uniqueId  限流唯一ID
     * @param codeLimit 超时时间内最大生成次数
     * @param context   验证码配置上下文
     * @return 验证码信息
     */
    public ImageCaptcha createNumberCaptcha(String uniqueId, int codeLimit, CaptchaContext context) {
        context.setSourceId(uniqueId)
                .setCodeLimit(codeLimit);
        return createCaptcha(context, new RandomGenerator(RandomUtil.BASE_NUMBER, context.getCodeLength()));
    }

    /**
     * 生成仅包含数字的验证码
     *
     * @param uniqueId  限流唯一ID
     * @param codeLimit 超时时间内最大生成次数
     * @return 验证码信息
     */
    public ImageCaptcha createNumberCaptcha(String uniqueId, int codeLimit) {
        CaptchaContext context = new CaptchaContext();
        context.setSourceId(uniqueId)
                .setCodeLimit(codeLimit);
        return createCaptcha(context, new RandomGenerator(RandomUtil.BASE_NUMBER, context.getCodeLength()));
    }

    /**
     * 生成包含char+数字的验证码
     *
     * @return 验证码信息
     */
    public ImageCaptcha createCharNumberCaptcha() {
        CaptchaContext context = new CaptchaContext();
        return createCaptcha(context, new RandomGenerator(RandomUtil.BASE_CHAR_NUMBER, context.getCodeLength()));
    }

    /**
     * 生成包含char+数字的验证码
     *
     * @param context 验证码配置上下文
     * @return 验证码信息
     */
    public ImageCaptcha createCharNumberCaptcha(CaptchaContext context) {
        return createCaptcha(context, new RandomGenerator(RandomUtil.BASE_CHAR_NUMBER, context.getCodeLength()));
    }

    /**
     * 生成包含char+数字的验证码
     *
     * @param uniqueId 限流唯一ID
     * @param context  验证码配置上下文
     * @return 验证码信息
     */
    public ImageCaptcha createCharNumberCaptcha(String uniqueId, CaptchaContext context) {
        context.setSourceId(uniqueId);
        return createCaptcha(context, new RandomGenerator(RandomUtil.BASE_CHAR_NUMBER, context.getCodeLength()));
    }

    /**
     * 生成包含char+数字的验证码
     *
     * @param uniqueId 限流唯一ID
     * @return 验证码信息
     */
    public ImageCaptcha createCharNumberCaptcha(String uniqueId) {
        CaptchaContext context = new CaptchaContext();
        context.setSourceId(uniqueId);
        return createCaptcha(context, new RandomGenerator(RandomUtil.BASE_CHAR_NUMBER, context.getCodeLength()));
    }

    /**
     * 生成包含char+数字的验证码
     *
     * @param uniqueId  限流唯一ID
     * @param codeLimit 超时时间内最大生成次数
     * @return 验证码信息
     */
    public ImageCaptcha createCharNumberCaptcha(String uniqueId, int codeLimit) {
        CaptchaContext context = new CaptchaContext();
        context.setSourceId(uniqueId)
                .setCodeLimit(codeLimit);
        return createCaptcha(context, new RandomGenerator(RandomUtil.BASE_CHAR_NUMBER, context.getCodeLength()));
    }

    /**
     * 生成四则运算的验证码
     *
     * @return 验证码信息
     */
    public ImageCaptcha createMatchCaptcha() {
        CaptchaContext context = new CaptchaContext();
        return createCaptcha(context, new MathGenerator(context.getMathNumberLength()));
    }

    /**
     * 生成四则运算的验证码
     *
     * @param context 验证码配置上下文
     * @return 验证码信息
     */
    public ImageCaptcha createMatchCaptcha(CaptchaContext context) {
        return createCaptcha(context, new MathGenerator(context.getMathNumberLength()));
    }

    /**
     * 生成四则运算的验证码
     *
     * @param uniqueId 限流唯一ID
     * @param context  验证码配置上下文
     * @return 验证码信息
     */
    public ImageCaptcha createMatchCaptcha(String uniqueId, CaptchaContext context) {
        context.setSourceId(uniqueId);
        return createCaptcha(context, new MathGenerator(context.getMathNumberLength()));
    }

    /**
     * 生成四则运算的验证码
     *
     * @param uniqueId 限流唯一ID
     * @return 验证码信息
     */
    public ImageCaptcha createMatchCaptcha(String uniqueId) {
        CaptchaContext context = new CaptchaContext();
        context.setSourceId(uniqueId);
        return createCaptcha(context, new MathGenerator(context.getMathNumberLength()));
    }

    /**
     * 生成四则运算的验证码
     *
     * @param uniqueId  限流唯一ID
     * @param codeLimit 超时时间内最大生成次数
     * @param context   验证码配置上下文
     * @return 验证码信息
     */
    public ImageCaptcha createMatchCaptcha(String uniqueId, int codeLimit, CaptchaContext context) {
        context.setSourceId(uniqueId)
                .setCodeLimit(codeLimit);
        return createCaptcha(context, new MathGenerator(context.getMathNumberLength()));
    }

    /**
     * 生成四则运算的验证码
     *
     * @param uniqueId  限流唯一ID
     * @param codeLimit 超时时间内最大生成次数
     * @return 验证码信息
     */
    public ImageCaptcha createMatchCaptcha(String uniqueId, int codeLimit) {
        CaptchaContext context = new CaptchaContext();
        context.setSourceId(uniqueId)
                .setCodeLimit(codeLimit);
        return createCaptcha(context, new MathGenerator(context.getMathNumberLength()));
    }

    /**
     * 验证码生成通用逻辑
     */
    public ImageCaptcha createCaptcha(CaptchaContext context, CodeGenerator generator) {
        AbstractCaptcha abstractCaptcha = abstractCaptcha(context);
        abstractCaptcha.setGenerator(generator);
        //设置验证码背景颜色
        abstractCaptcha.setBackground(context.getColor());
        //设置验证码字体
        abstractCaptcha.setFont(context.getFont());
        abstractCaptcha.createCode();
        String captchaCode = abstractCaptcha.getCode();
        context.setCaptchaCode(String.valueOf((int) Calculator.conversion(captchaCode)));
        CaptchaInfo captchaInfo = createCaptcha(context);
        return new ImageCaptcha().setCaptchaId(captchaInfo.getCaptchaId())
                .setCodeTimeout(captchaInfo.getCodeTimeout())
                .setCaptchaImg(abstractCaptcha.getImageBase64());
    }


    abstract public AbstractCaptcha abstractCaptcha(CaptchaContext context);
}
