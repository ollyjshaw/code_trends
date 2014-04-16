package service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oliver.shaw
 * Date: 16/04/14
 * Time: 09:33
 * To change this template use File | Settings | File Templates.
 */
public class CodeTrendViewModel {

    private final List<CodeTrendItem> items;

    public CodeTrendViewModel(List<CodeTrendItem> items) {
        this.items = items;
    }

    public List<CodeTrendItem> getData() {

        return Collections.unmodifiableList( items);
    }
}
