package prafull.com.mymiwok;

public class Word {

    private String defaultTranslation;
    private String miwokTranslation;

    // Drawable resource ID
    private int mImageResourceId;

    public int getmImageResourceId2() {
        return mImageResourceId2;
    }

    public void setmImageResourceId2(int mImageResourceId2) {
        this.mImageResourceId2 = mImageResourceId2;
    }

    private int mImageResourceId2;

    public Word(String defaultTranslation, String miwokTranslation, int mImageResourceId,int mImageResourceId2) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.mImageResourceId = mImageResourceId;
        this.mImageResourceId2=mImageResourceId2;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public void setDefaultTranslation(String defaultTranslation) {
        this.defaultTranslation = defaultTranslation;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }

    public void setMiwokTranslation(String miwokTranslation) {
        this.miwokTranslation = miwokTranslation;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public void setmImageResourceId(int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }
}
