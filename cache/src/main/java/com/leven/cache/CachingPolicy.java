package com.leven.cache;

/**
 * @Author: LevenLiu
 * @Description: Enum class containing the for caching strategies implemented in the pattern
 * @Date: Create 23:32 2018/8/1
 * @Modified By:
 */
public enum CachingPolicy {
    THROUGH("through"),AROUND("around"),BEHIND("behind"),ASIDE("aside");
    private String policy;
    CachingPolicy(String policy) {
        this.policy = policy;
    }

    public String getPolicy() {
        return policy;
    }
}
