package at.tugraz.ist.cc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import at.tugraz.ist.cc.error.ErrorHandler;
import org.junit.Test;


public class LexicalAndSyntaxPublicTest {

    private final String path_lexer = "src/test/resources/public/input/lexer/";
    private final String path_parser = "src/test/resources/public/input/parser/";

    LexicalAndSyntaxAnalyzer lexAndSyntax = new LexicalAndSyntaxAnalyzer();
    boolean debug = true;

    @Test
    public void testLexerPass01() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.lexer(path_lexer + "pass01.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testLexerPass02() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.lexer(path_lexer + "pass02.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testLexerPass03() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.lexer(path_lexer + "pass03.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testLexerPass04() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.lexer(path_lexer + "pass04.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testLexerPass05() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.lexer(path_lexer + "pass05.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testLexerFail01() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.lexer(path_lexer + "fail01.jova", debug);
        assertTrue(result > 0);
    }

    @Test
    public void testLexerFail02() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.lexer(path_lexer + "fail02.jova", debug);
        assertTrue(result > 0);
    }

    @Test
    public void testLexerFail03() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.lexer(path_lexer + "fail03.jova", debug);
        assertTrue(result > 0);
    }

    @Test
    public void testLexerFail04() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.lexer(path_lexer + "fail04.jova", debug);
        assertTrue(result > 0);
    }

    @Test
    public void testLexerFail05() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.lexer(path_lexer + "fail05.jova", debug);
        assertTrue(result > 0);
    }

    @Test
    public void testLexerFail06() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.lexer(path_lexer + "fail06.jova", debug);
        assertTrue(result > 0);
    }

    @Test
    public void testLexerFail07() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.lexer(path_lexer + "fail07.jova", debug);
        assertTrue(result > 0);
    }

    @Test
    public void testLexerFail08() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.lexer(path_lexer + "fail08.jova", debug);
        assertTrue(result > 0);
    }

    @Test
    public void testLexerFail09() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.lexer(path_lexer + "fail09.jova", debug);
        assertTrue(result > 0);
    }

    @Test
    public void testLexerFail10() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.lexer(path_lexer + "fail10.jova", debug);
        assertTrue(result > 0);
    }


    // PARSER

    @Test
    public void testParserPass01() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "pass01.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testParserPass02() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "pass02.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testParserPass03() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "pass03.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testParserPass04() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "pass04.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testParserPass05() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "pass05.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testParserPass06() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "pass06.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testParserPass07() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "pass07.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testParserPass08() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "pass08.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testParserPass09() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "pass09.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testParserPass10() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "pass10.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testParserPass11() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "pass11.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testParserPass12() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "pass12.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testParserPass15() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "pass15.jova", debug);
        assertEquals(0, result);
    }

    @Test
    public void testParserFail01() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail01.jova", debug);
        assertTrue(result > 0);
    }

    @Test
    public void testParserFail02() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail02.jova", debug);
        assertTrue(result > 0);
    }

    @Test
    public void testParserFail03() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail03.jova", debug);
        assertTrue(result > 0);
    }

    @Test
    public void testParserFail04() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail04.jova", debug);
        assertTrue(result > 0);
    }

    @Test
    public void testParserFail05() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail05.jova", debug);
        assertTrue(result > 0);
    }

    @Test
    public void testParserFail06() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail06.jova", debug);
        assertTrue(result > 0);
    }
    @Test
    public void testParserFail07() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail07.jova", debug);
        assertTrue(result > 0);
    }
    @Test
    public void testParserFail08() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail08.jova", debug);
        assertTrue(result > 0);
    }
    @Test
    public void testParserFail09() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail09.jova", debug);
        assertTrue(result > 0);
    }
    @Test
    public void testParserFail10() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail10.jova", debug);
        assertTrue(result > 0);
    }
    @Test
    public void testParserFail11() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail11.jova", debug);
        assertTrue(result > 0);
    }
    @Test
    public void testParserFail12() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail12.jova", debug);
        assertTrue(result > 0);
    }
    @Test
    public void testParserFail13() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail13.jova", debug);
        assertTrue(result > 0);
    }
    @Test
    public void testParserFail14() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail14.jova", debug);
        assertTrue(result > 0);
    }
    @Test
    public void testParserFail15() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail15.jova", debug);
        assertTrue(result > 0);
    }
    @Test
    public void testParserFail16() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail16.jova", debug);
        assertTrue(result > 0);
    }
    @Test
    public void testParserFail17() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail17.jova", debug);
        assertTrue(result > 0);
    }
    @Test
    public void testParserFail18() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail18.jova", debug);
        assertTrue(result > 0);
    }
    @Test
    public void testParserFail19() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail19.jova", debug);
        assertTrue(result > 0);
    }
    @Test
    public void testParserFail20() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail20.jova", debug);
        assertTrue(result > 0);
    }
            @Test
    public void testParserFail21() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail21.jova", debug);
        assertTrue(result > 0);
    }
    @Test
    public void testParserFail22() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail22.jova", debug);
        assertTrue(result > 0);
    }
    @Test
    public void testParserFail23() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail23.jova", debug);
        assertTrue(result > 0);
    }
    @Test
    public void testParserFail24() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail24.jova", debug);
        assertTrue(result > 0);
    }

    @Test
    public void testParserFail25() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail25.jova", debug);
        assertTrue(result > 0);
    }

    @Test
    public void testParserFail26() {
        ErrorHandler.INSTANCE.reset();
        int result = lexAndSyntax.parser(path_parser + "fail26.jova", debug);
        assertTrue(result > 0);
    }
}
