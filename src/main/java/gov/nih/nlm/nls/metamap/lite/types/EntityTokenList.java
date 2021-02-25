package gov.nih.nlm.nls.metamap.lite.types;

import gov.nih.nlm.nls.metamap.prefix.ERToken;

import java.util.List;

public class EntityTokenList {
    List<Entity> entities;
    List<ERToken> tokens;

    public EntityTokenList(List<Entity> entities, List<ERToken> tokenList) {
        this.entities = entities;
        this.tokens = tokenList;
    }

    public List<Entity> getEntities() {
        return this.entities;
    }

    public List<ERToken> getTokens() {
        return this.tokens;
    }
}
