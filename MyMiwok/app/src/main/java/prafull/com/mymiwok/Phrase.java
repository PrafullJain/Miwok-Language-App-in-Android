package prafull.com.mymiwok;

public class Phrase {
    private String defaultTranslation;
    private String miwokTranslation;

    // Drawable resource ID
    private int mImageResourceId;

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public void setmImageResourceId(int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }
    // Drawable resource ID

    public Phrase(String defaultTranslation, String miwokTranslation,int mImageResourceId) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.mImageResourceId=mImageResourceId;
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

}
