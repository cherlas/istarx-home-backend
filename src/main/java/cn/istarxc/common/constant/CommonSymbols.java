package cn.istarxc.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author istarx
 * @date 2022-1-14
 */
@Getter
@AllArgsConstructor
public enum CommonSymbols {
    /**
     * common symbols in chinese and english
     */
    COLON(":", "："),
    SLASH("/", "/"),
    DOUBLE_SLASH("//", "//"),
    COMMA(",", "，"),
    SINGLE_QUOTATION("'", "'"),
    LEFT_DOUBLE_QUOTATION("\"", "“"),
    RIGHT_DOUBLE_QUOTATION("\"", "”"),
    AT_SIGN("@", "@");

    private final String englishSymbol;
    private final String chineseSymbol;
}
