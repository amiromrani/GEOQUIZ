package com.ctech.amir.geoquiz;

public class Question {

    private int mTextRedId;
    private boolean mAnswerTrue;

    public Question(int textResId, boolean answerTrue) {
        mTextRedId = textResId;
        mAnswerTrue = answerTrue;
    }

    public int getTextRedId() {
        return mTextRedId;
    }

    public void setTextRedId(int textRedId) {
        mTextRedId = textRedId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
