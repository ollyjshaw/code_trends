package view_models;

import services.CodeTrendItem;

import java.util.Collections;
import java.util.List;

public class CodeTrendViewModel {

    private final List<CodeTrendItem> items;

    public CodeTrendViewModel(List<CodeTrendItem> items) {
        this.items = items;
    }

    public List<CodeTrendItem> getData() {

        return Collections.unmodifiableList( items);//
    }
}
