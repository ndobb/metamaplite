package gov.nih.nlm.nls.metamap.prefix;

import java.io.Serializable;

public class PosTokenImpl implements PosToken, Token, Serializable {
    String tokenText;
    int offset;
    int index;

    public PosTokenImpl(String tokenText, int offset) {
        this.tokenText = tokenText;
        this.offset = offset;
    }

    public PosTokenImpl(String tokenText, int offset, int index) {
        this.tokenText = tokenText;
        this.offset = offset;
        this.index = index;
    }

    public String getText() {
        return this.tokenText;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getIndex() {
        return this.index;
    }

    @Deprecated
    public int getPosition() {
        return this.offset;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"").append(this.tokenText).append("\"|").append(this.offset);
        return sb.toString();
    }

    public boolean equals(Object o) {
        return this.tokenText.equals(((PosTokenImpl) o).tokenText);
    }
}
