package cn.interestingshop.utils;

/**
 * 线程本地变量上下文，用于在同一线程内的不同层次间传递参数
 */
public class ThreadLocalContext {
    
    private static final ThreadLocal<Integer> LEVEL_HOLDER = new ThreadLocal<>();
    
    /**
     * 设置分类级别
     * @param level 分类级别(1,2,3)
     */
    public static void setLevel(Integer level) {
        LEVEL_HOLDER.set(level);
    }
    
    /**
     * 获取分类级别
     * @return 分类级别，默认为1
     */
    public static Integer getLevel() {
        Integer level = LEVEL_HOLDER.get();
        return level != null ? level : 1; // 默认为1级分类
    }
    
    /**
     * 清除线程变量，防止内存泄漏
     * 应在请求结束时调用
     */
    public static void clear() {
        LEVEL_HOLDER.remove();
    }
} 