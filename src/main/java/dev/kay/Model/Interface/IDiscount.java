package dev.kay.Model.Interface;

public interface IDiscount {

    public static final float DISCOUNT_10 = 0.1f;
    public static final float DISCOUNT_20 = 0.2f;
    public static final float DISCOUNT_30 = 0.3f;
    public static final float DISCOUNT_40 = 0.4f;
    public static final float DISCOUNT_50 = 0.5f;
    public static final float DISCOUNT_60 = 0.6f;
    public static final float DISCOUNT_70 = 0.7f;
    public static final float DISCOUNT_80 = 0.8f;
    public static final float DISCOUNT_90 = 0.9f;
    public static final float DISCOUNT_100 = 1f;


    /**
     * If some Order has discount, you must be using this class to add discount to that Order
     * @param rootPrice Initial price of order
     * @param percentDiscount percent discount which Order has
     * @return final price of Order
     */
    public float enableDiscount(float rootPrice, float percentDiscount);

}
