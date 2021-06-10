// Generated from D:/Documents/GIT/compiler_construction/src/main/antlr/at/tugraz/ist/cc\Jova.g4 by ANTLR 4.8

	package at.tugraz.ist.cc;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JovaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, KEY_CLASS=8, KEY_IF=9, 
		KEY_ELSE=10, KEY_WHILE=11, KEY_RETURN=12, KEY_NEW=13, KEY_NIX=14, AMOD=15, 
		PRIMITIVE_TYPE=16, CLASS_TYPE=17, ASSIGN=18, RELOP=19, MULOP=20, AND=21, 
		OR=22, ADDOP=23, NOT=24, DOTOP=25, TERNOP=26, INT_LIT=27, BOOL_LIT=28, 
		ID=29, STRING_LIT=30, COMMENT=31, BLOCK_COMMENT=32, WS=33;
	public static final int
		RULE_program = 0, RULE_type = 1, RULE_class_decl = 2, RULE_class_head = 3, 
		RULE_class_body = 4, RULE_ctor = 5, RULE_ctor_body = 6, RULE_member_decl = 7, 
		RULE_id_list = 8, RULE_method_decl = 9, RULE_method_head = 10, RULE_params = 11, 
		RULE_param_list = 12, RULE_method_body = 13, RULE_stmt = 14, RULE_compound_stmt = 15, 
		RULE_declaration = 16, RULE_ret_stmt = 17, RULE_assign_stmt = 18, RULE_member_access = 19, 
		RULE_method_invocation = 20, RULE_chain_method_invocation = 21, RULE_id_expr = 22, 
		RULE_arg_list = 23, RULE_expr = 24, RULE_unary_expr = 25, RULE_primary_expr = 26, 
		RULE_object_alloc = 27, RULE_ctor_args = 28, RULE_paran_expr = 29, RULE_literal = 30, 
		RULE_control_stmt = 31, RULE_if_stmt = 32, RULE_while_stmt = 33;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "type", "class_decl", "class_head", "class_body", "ctor", 
			"ctor_body", "member_decl", "id_list", "method_decl", "method_head", 
			"params", "param_list", "method_body", "stmt", "compound_stmt", "declaration", 
			"ret_stmt", "assign_stmt", "member_access", "method_invocation", "chain_method_invocation", 
			"id_expr", "arg_list", "expr", "unary_expr", "primary_expr", "object_alloc", 
			"ctor_args", "paran_expr", "literal", "control_stmt", "if_stmt", "while_stmt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "';'", "','", "'('", "')'", "':'", "'class'", "'if'", 
			"'else'", "'while'", "'return'", "'new'", "'nix'", null, null, null, 
			"'='", null, null, "'&&'", "'||'", null, "'!'", "'.'", "'?'", "'0'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "KEY_CLASS", "KEY_IF", 
			"KEY_ELSE", "KEY_WHILE", "KEY_RETURN", "KEY_NEW", "KEY_NIX", "AMOD", 
			"PRIMITIVE_TYPE", "CLASS_TYPE", "ASSIGN", "RELOP", "MULOP", "AND", "OR", 
			"ADDOP", "NOT", "DOTOP", "TERNOP", "INT_LIT", "BOOL_LIT", "ID", "STRING_LIT", 
			"COMMENT", "BLOCK_COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Jova.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JovaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(JovaParser.EOF, 0); }
		public List<Class_declContext> class_decl() {
			return getRuleContexts(Class_declContext.class);
		}
		public Class_declContext class_decl(int i) {
			return getRuleContext(Class_declContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(68);
				class_decl();
				}
				}
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==KEY_CLASS );
			setState(73);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode PRIMITIVE_TYPE() { return getToken(JovaParser.PRIMITIVE_TYPE, 0); }
		public TerminalNode CLASS_TYPE() { return getToken(JovaParser.CLASS_TYPE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_la = _input.LA(1);
			if ( !(_la==PRIMITIVE_TYPE || _la==CLASS_TYPE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_declContext extends ParserRuleContext {
		public Class_headContext class_head() {
			return getRuleContext(Class_headContext.class,0);
		}
		public Class_bodyContext class_body() {
			return getRuleContext(Class_bodyContext.class,0);
		}
		public Class_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterClass_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitClass_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitClass_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_declContext class_decl() throws RecognitionException {
		Class_declContext _localctx = new Class_declContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_class_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			class_head();
			setState(78);
			class_body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_headContext extends ParserRuleContext {
		public TerminalNode KEY_CLASS() { return getToken(JovaParser.KEY_CLASS, 0); }
		public TerminalNode CLASS_TYPE() { return getToken(JovaParser.CLASS_TYPE, 0); }
		public Class_headContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_head; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterClass_head(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitClass_head(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitClass_head(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_headContext class_head() throws RecognitionException {
		Class_headContext _localctx = new Class_headContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_class_head);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(KEY_CLASS);
			setState(81);
			match(CLASS_TYPE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_bodyContext extends ParserRuleContext {
		public List<Member_declContext> member_decl() {
			return getRuleContexts(Member_declContext.class);
		}
		public Member_declContext member_decl(int i) {
			return getRuleContext(Member_declContext.class,i);
		}
		public List<Method_declContext> method_decl() {
			return getRuleContexts(Method_declContext.class);
		}
		public Method_declContext method_decl(int i) {
			return getRuleContext(Method_declContext.class,i);
		}
		public List<CtorContext> ctor() {
			return getRuleContexts(CtorContext.class);
		}
		public CtorContext ctor(int i) {
			return getRuleContext(CtorContext.class,i);
		}
		public Class_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterClass_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitClass_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitClass_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_bodyContext class_body() throws RecognitionException {
		Class_bodyContext _localctx = new Class_bodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_class_body);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__0);
			setState(87);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(84);
					member_decl();
					}
					} 
				}
				setState(89);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AMOD || _la==CLASS_TYPE) {
				{
				setState(92);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case AMOD:
					{
					setState(90);
					method_decl();
					}
					break;
				case CLASS_TYPE:
					{
					setState(91);
					ctor();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(97);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CtorContext extends ParserRuleContext {
		public TerminalNode CLASS_TYPE() { return getToken(JovaParser.CLASS_TYPE, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public Ctor_bodyContext ctor_body() {
			return getRuleContext(Ctor_bodyContext.class,0);
		}
		public CtorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterCtor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitCtor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitCtor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CtorContext ctor() throws RecognitionException {
		CtorContext _localctx = new CtorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ctor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(CLASS_TYPE);
			setState(100);
			params();
			setState(101);
			ctor_body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ctor_bodyContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public Ctor_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctor_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterCtor_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitCtor_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitCtor_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ctor_bodyContext ctor_body() throws RecognitionException {
		Ctor_bodyContext _localctx = new Ctor_bodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ctor_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__0);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PRIMITIVE_TYPE || _la==CLASS_TYPE) {
				{
				{
				setState(104);
				declaration();
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEY_IF) | (1L << KEY_WHILE) | (1L << ID))) != 0)) {
				{
				{
				setState(110);
				stmt();
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Member_declContext extends ParserRuleContext {
		public TerminalNode AMOD() { return getToken(JovaParser.AMOD, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public Member_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterMember_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitMember_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitMember_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Member_declContext member_decl() throws RecognitionException {
		Member_declContext _localctx = new Member_declContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_member_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(AMOD);
			setState(119);
			type();
			setState(120);
			id_list();
			setState(121);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Id_listContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(JovaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(JovaParser.ID, i);
		}
		public Id_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterId_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitId_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitId_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Id_listContext id_list() throws RecognitionException {
		Id_listContext _localctx = new Id_listContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_id_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(ID);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(124);
				match(T__3);
				setState(125);
				match(ID);
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Method_declContext extends ParserRuleContext {
		public Method_headContext method_head() {
			return getRuleContext(Method_headContext.class,0);
		}
		public Method_bodyContext method_body() {
			return getRuleContext(Method_bodyContext.class,0);
		}
		public Method_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterMethod_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitMethod_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitMethod_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_declContext method_decl() throws RecognitionException {
		Method_declContext _localctx = new Method_declContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_method_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			method_head();
			setState(132);
			method_body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Method_headContext extends ParserRuleContext {
		public TerminalNode AMOD() { return getToken(JovaParser.AMOD, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(JovaParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public Method_headContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_head; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterMethod_head(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitMethod_head(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitMethod_head(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_headContext method_head() throws RecognitionException {
		Method_headContext _localctx = new Method_headContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_method_head);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(AMOD);
			setState(135);
			type();
			setState(136);
			match(ID);
			setState(137);
			params();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public Param_listContext param_list() {
			return getRuleContext(Param_listContext.class,0);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(T__4);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PRIMITIVE_TYPE || _la==CLASS_TYPE) {
				{
				setState(140);
				param_list();
				}
			}

			setState(143);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_listContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(JovaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(JovaParser.ID, i);
		}
		public Param_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterParam_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitParam_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitParam_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_listContext param_list() throws RecognitionException {
		Param_listContext _localctx = new Param_listContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			type();
			setState(146);
			match(ID);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(147);
				match(T__3);
				setState(148);
				type();
				setState(149);
				match(ID);
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Method_bodyContext extends ParserRuleContext {
		public Ret_stmtContext ret_stmt() {
			return getRuleContext(Ret_stmtContext.class,0);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public Method_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterMethod_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitMethod_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitMethod_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_bodyContext method_body() throws RecognitionException {
		Method_bodyContext _localctx = new Method_bodyContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_method_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(T__0);
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PRIMITIVE_TYPE || _la==CLASS_TYPE) {
				{
				{
				setState(157);
				declaration();
				}
				}
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEY_IF) | (1L << KEY_WHILE) | (1L << ID))) != 0)) {
				{
				{
				setState(163);
				stmt();
				}
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(169);
			ret_stmt();
			setState(170);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public Control_stmtContext control_stmt() {
			return getRuleContext(Control_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stmt);
		try {
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				assign_stmt();
				setState(173);
				match(T__2);
				}
				break;
			case KEY_IF:
			case KEY_WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				control_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Compound_stmtContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterCompound_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitCompound_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitCompound_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_compound_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(T__0);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEY_IF) | (1L << KEY_WHILE) | (1L << ID))) != 0)) {
				{
				{
				setState(179);
				stmt();
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(185);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			type();
			setState(188);
			id_list();
			setState(189);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ret_stmtContext extends ParserRuleContext {
		public TerminalNode KEY_RETURN() { return getToken(JovaParser.KEY_RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Ret_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterRet_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitRet_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitRet_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ret_stmtContext ret_stmt() throws RecognitionException {
		Ret_stmtContext _localctx = new Ret_stmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ret_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(KEY_RETURN);
			setState(192);
			expr(0);
			setState(193);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_stmtContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JovaParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(JovaParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Object_allocContext object_alloc() {
			return getRuleContext(Object_allocContext.class,0);
		}
		public List<Member_accessContext> member_access() {
			return getRuleContexts(Member_accessContext.class);
		}
		public Member_accessContext member_access(int i) {
			return getRuleContext(Member_accessContext.class,i);
		}
		public Assign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterAssign_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitAssign_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitAssign_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_stmtContext assign_stmt() throws RecognitionException {
		Assign_stmtContext _localctx = new Assign_stmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_assign_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(ID);
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOTOP) {
				{
				{
				setState(196);
				member_access();
				}
				}
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(202);
			match(ASSIGN);
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case KEY_NIX:
			case ADDOP:
			case NOT:
			case INT_LIT:
			case BOOL_LIT:
			case ID:
			case STRING_LIT:
				{
				setState(203);
				expr(0);
				}
				break;
			case KEY_NEW:
				{
				setState(204);
				object_alloc();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Member_accessContext extends ParserRuleContext {
		public TerminalNode DOTOP() { return getToken(JovaParser.DOTOP, 0); }
		public TerminalNode ID() { return getToken(JovaParser.ID, 0); }
		public Member_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterMember_access(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitMember_access(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitMember_access(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Member_accessContext member_access() throws RecognitionException {
		Member_accessContext _localctx = new Member_accessContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_member_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(DOTOP);
			setState(208);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Method_invocationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JovaParser.ID, 0); }
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public Method_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_invocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterMethod_invocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitMethod_invocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitMethod_invocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_invocationContext method_invocation() throws RecognitionException {
		Method_invocationContext _localctx = new Method_invocationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_method_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(ID);
			setState(211);
			match(T__4);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << KEY_NIX) | (1L << ADDOP) | (1L << NOT) | (1L << INT_LIT) | (1L << BOOL_LIT) | (1L << ID) | (1L << STRING_LIT))) != 0)) {
				{
				setState(212);
				arg_list();
				}
			}

			setState(215);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Chain_method_invocationContext extends ParserRuleContext {
		public TerminalNode DOTOP() { return getToken(JovaParser.DOTOP, 0); }
		public Method_invocationContext method_invocation() {
			return getRuleContext(Method_invocationContext.class,0);
		}
		public Chain_method_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chain_method_invocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterChain_method_invocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitChain_method_invocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitChain_method_invocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Chain_method_invocationContext chain_method_invocation() throws RecognitionException {
		Chain_method_invocationContext _localctx = new Chain_method_invocationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_chain_method_invocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(DOTOP);
			setState(218);
			method_invocation();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Id_exprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JovaParser.ID, 0); }
		public List<Member_accessContext> member_access() {
			return getRuleContexts(Member_accessContext.class);
		}
		public Member_accessContext member_access(int i) {
			return getRuleContext(Member_accessContext.class,i);
		}
		public Chain_method_invocationContext chain_method_invocation() {
			return getRuleContext(Chain_method_invocationContext.class,0);
		}
		public Id_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterId_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitId_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitId_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Id_exprContext id_expr() throws RecognitionException {
		Id_exprContext _localctx = new Id_exprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_id_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(ID);
			setState(224);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(221);
					member_access();
					}
					} 
				}
				setState(226);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(227);
				chain_method_invocation();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Arg_listContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Arg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterArg_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitArg_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitArg_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arg_listContext arg_list() throws RecognitionException {
		Arg_listContext _localctx = new Arg_listContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_arg_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			expr(0);
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(231);
				match(T__3);
				setState(232);
				expr(0);
				}
				}
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Primary_exprContext primary_expr() {
			return getRuleContext(Primary_exprContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULOP() { return getToken(JovaParser.MULOP, 0); }
		public TerminalNode ADDOP() { return getToken(JovaParser.ADDOP, 0); }
		public TerminalNode RELOP() { return getToken(JovaParser.RELOP, 0); }
		public TerminalNode AND() { return getToken(JovaParser.AND, 0); }
		public TerminalNode OR() { return getToken(JovaParser.OR, 0); }
		public TerminalNode TERNOP() { return getToken(JovaParser.TERNOP, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(239);
			primary_expr();
			}
			_ctx.stop = _input.LT(-1);
			setState(266);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(264);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(241);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(242);
						match(MULOP);
						setState(243);
						expr(7);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(244);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(245);
						match(ADDOP);
						setState(246);
						expr(6);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(247);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(248);
						match(RELOP);
						setState(249);
						expr(5);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(250);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(251);
						match(AND);
						setState(252);
						expr(4);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(253);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(254);
						match(OR);
						setState(255);
						expr(3);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(256);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(257);
						match(RELOP);
						setState(258);
						expr(0);
						setState(259);
						match(TERNOP);
						setState(260);
						expr(0);
						setState(261);
						match(T__6);
						setState(262);
						expr(1);
						}
						break;
					}
					} 
				}
				setState(268);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Unary_exprContext extends ParserRuleContext {
		public Primary_exprContext primary_expr() {
			return getRuleContext(Primary_exprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(JovaParser.NOT, 0); }
		public TerminalNode ADDOP() { return getToken(JovaParser.ADDOP, 0); }
		public Unary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterUnary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitUnary_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitUnary_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_exprContext unary_expr() throws RecognitionException {
		Unary_exprContext _localctx = new Unary_exprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unary_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			_la = _input.LA(1);
			if ( !(_la==ADDOP || _la==NOT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(270);
			primary_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Primary_exprContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public Id_exprContext id_expr() {
			return getRuleContext(Id_exprContext.class,0);
		}
		public Method_invocationContext method_invocation() {
			return getRuleContext(Method_invocationContext.class,0);
		}
		public Paran_exprContext paran_expr() {
			return getRuleContext(Paran_exprContext.class,0);
		}
		public Unary_exprContext unary_expr() {
			return getRuleContext(Unary_exprContext.class,0);
		}
		public Primary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterPrimary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitPrimary_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitPrimary_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Primary_exprContext primary_expr() throws RecognitionException {
		Primary_exprContext _localctx = new Primary_exprContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_primary_expr);
		try {
			setState(277);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(272);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(273);
				id_expr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(274);
				method_invocation();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(275);
				paran_expr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(276);
				unary_expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Object_allocContext extends ParserRuleContext {
		public TerminalNode KEY_NEW() { return getToken(JovaParser.KEY_NEW, 0); }
		public TerminalNode CLASS_TYPE() { return getToken(JovaParser.CLASS_TYPE, 0); }
		public Ctor_argsContext ctor_args() {
			return getRuleContext(Ctor_argsContext.class,0);
		}
		public Object_allocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object_alloc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterObject_alloc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitObject_alloc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitObject_alloc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Object_allocContext object_alloc() throws RecognitionException {
		Object_allocContext _localctx = new Object_allocContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_object_alloc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(KEY_NEW);
			setState(280);
			match(CLASS_TYPE);
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(281);
				ctor_args();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ctor_argsContext extends ParserRuleContext {
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public Ctor_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctor_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterCtor_args(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitCtor_args(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitCtor_args(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ctor_argsContext ctor_args() throws RecognitionException {
		Ctor_argsContext _localctx = new Ctor_argsContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_ctor_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(T__4);
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << KEY_NIX) | (1L << ADDOP) | (1L << NOT) | (1L << INT_LIT) | (1L << BOOL_LIT) | (1L << ID) | (1L << STRING_LIT))) != 0)) {
				{
				setState(285);
				arg_list();
				}
			}

			setState(288);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Paran_exprContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Paran_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paran_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterParan_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitParan_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitParan_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Paran_exprContext paran_expr() throws RecognitionException {
		Paran_exprContext _localctx = new Paran_exprContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_paran_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(T__4);
			setState(291);
			expr(0);
			setState(292);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode INT_LIT() { return getToken(JovaParser.INT_LIT, 0); }
		public TerminalNode BOOL_LIT() { return getToken(JovaParser.BOOL_LIT, 0); }
		public TerminalNode STRING_LIT() { return getToken(JovaParser.STRING_LIT, 0); }
		public TerminalNode KEY_NIX() { return getToken(JovaParser.KEY_NIX, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEY_NIX) | (1L << INT_LIT) | (1L << BOOL_LIT) | (1L << STRING_LIT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Control_stmtContext extends ParserRuleContext {
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public Control_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_control_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterControl_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitControl_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitControl_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Control_stmtContext control_stmt() throws RecognitionException {
		Control_stmtContext _localctx = new Control_stmtContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_control_stmt);
		try {
			setState(298);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEY_IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				if_stmt();
				}
				break;
			case KEY_WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				while_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode KEY_IF() { return getToken(JovaParser.KEY_IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<Compound_stmtContext> compound_stmt() {
			return getRuleContexts(Compound_stmtContext.class);
		}
		public Compound_stmtContext compound_stmt(int i) {
			return getRuleContext(Compound_stmtContext.class,i);
		}
		public TerminalNode KEY_ELSE() { return getToken(JovaParser.KEY_ELSE, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitIf_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitIf_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(KEY_IF);
			setState(301);
			match(T__4);
			setState(302);
			expr(0);
			setState(303);
			match(T__5);
			setState(304);
			compound_stmt();
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEY_ELSE) {
				{
				setState(305);
				match(KEY_ELSE);
				setState(306);
				compound_stmt();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_stmtContext extends ParserRuleContext {
		public TerminalNode KEY_WHILE() { return getToken(JovaParser.KEY_WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JovaListener ) ((JovaListener)listener).exitWhile_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JovaVisitor ) return ((JovaVisitor<? extends T>)visitor).visitWhile_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			match(KEY_WHILE);
			setState(310);
			match(T__4);
			setState(311);
			expr(0);
			setState(312);
			match(T__5);
			setState(313);
			compound_stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 24:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u013e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\6\2H\n\2\r\2\16\2I\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\6\3\6\7\6X\n\6\f\6\16\6[\13\6\3\6\3\6\7\6_\n\6\f\6\16\6b"+
		"\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\7\bl\n\b\f\b\16\bo\13\b\3\b\7\b"+
		"r\n\b\f\b\16\bu\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\7\n\u0081"+
		"\n\n\f\n\16\n\u0084\13\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\5"+
		"\r\u0090\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u009a\n\16\f\16"+
		"\16\16\u009d\13\16\3\17\3\17\7\17\u00a1\n\17\f\17\16\17\u00a4\13\17\3"+
		"\17\7\17\u00a7\n\17\f\17\16\17\u00aa\13\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\5\20\u00b3\n\20\3\21\3\21\7\21\u00b7\n\21\f\21\16\21\u00ba\13"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\7\24\u00c8"+
		"\n\24\f\24\16\24\u00cb\13\24\3\24\3\24\3\24\5\24\u00d0\n\24\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\5\26\u00d8\n\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30"+
		"\7\30\u00e1\n\30\f\30\16\30\u00e4\13\30\3\30\5\30\u00e7\n\30\3\31\3\31"+
		"\3\31\7\31\u00ec\n\31\f\31\16\31\u00ef\13\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u010b\n\32\f\32\16\32\u010e\13"+
		"\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\5\34\u0118\n\34\3\35\3\35"+
		"\3\35\5\35\u011d\n\35\3\36\3\36\5\36\u0121\n\36\3\36\3\36\3\37\3\37\3"+
		"\37\3\37\3 \3 \3!\3!\5!\u012d\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0136"+
		"\n\"\3#\3#\3#\3#\3#\3#\3#\2\3\62$\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>@BD\2\5\3\2\22\23\3\2\31\32\5\2\20\20\35\36"+
		"  \2\u013c\2G\3\2\2\2\4M\3\2\2\2\6O\3\2\2\2\bR\3\2\2\2\nU\3\2\2\2\fe\3"+
		"\2\2\2\16i\3\2\2\2\20x\3\2\2\2\22}\3\2\2\2\24\u0085\3\2\2\2\26\u0088\3"+
		"\2\2\2\30\u008d\3\2\2\2\32\u0093\3\2\2\2\34\u009e\3\2\2\2\36\u00b2\3\2"+
		"\2\2 \u00b4\3\2\2\2\"\u00bd\3\2\2\2$\u00c1\3\2\2\2&\u00c5\3\2\2\2(\u00d1"+
		"\3\2\2\2*\u00d4\3\2\2\2,\u00db\3\2\2\2.\u00de\3\2\2\2\60\u00e8\3\2\2\2"+
		"\62\u00f0\3\2\2\2\64\u010f\3\2\2\2\66\u0117\3\2\2\28\u0119\3\2\2\2:\u011e"+
		"\3\2\2\2<\u0124\3\2\2\2>\u0128\3\2\2\2@\u012c\3\2\2\2B\u012e\3\2\2\2D"+
		"\u0137\3\2\2\2FH\5\6\4\2GF\3\2\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JK\3\2"+
		"\2\2KL\7\2\2\3L\3\3\2\2\2MN\t\2\2\2N\5\3\2\2\2OP\5\b\5\2PQ\5\n\6\2Q\7"+
		"\3\2\2\2RS\7\n\2\2ST\7\23\2\2T\t\3\2\2\2UY\7\3\2\2VX\5\20\t\2WV\3\2\2"+
		"\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z`\3\2\2\2[Y\3\2\2\2\\_\5\24\13\2]_\5"+
		"\f\7\2^\\\3\2\2\2^]\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2ac\3\2\2\2b`"+
		"\3\2\2\2cd\7\4\2\2d\13\3\2\2\2ef\7\23\2\2fg\5\30\r\2gh\5\16\b\2h\r\3\2"+
		"\2\2im\7\3\2\2jl\5\"\22\2kj\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2ns\3"+
		"\2\2\2om\3\2\2\2pr\5\36\20\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2t"+
		"v\3\2\2\2us\3\2\2\2vw\7\4\2\2w\17\3\2\2\2xy\7\21\2\2yz\5\4\3\2z{\5\22"+
		"\n\2{|\7\5\2\2|\21\3\2\2\2}\u0082\7\37\2\2~\177\7\6\2\2\177\u0081\7\37"+
		"\2\2\u0080~\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\23\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\5\26\f\2\u0086"+
		"\u0087\5\34\17\2\u0087\25\3\2\2\2\u0088\u0089\7\21\2\2\u0089\u008a\5\4"+
		"\3\2\u008a\u008b\7\37\2\2\u008b\u008c\5\30\r\2\u008c\27\3\2\2\2\u008d"+
		"\u008f\7\7\2\2\u008e\u0090\5\32\16\2\u008f\u008e\3\2\2\2\u008f\u0090\3"+
		"\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\7\b\2\2\u0092\31\3\2\2\2\u0093"+
		"\u0094\5\4\3\2\u0094\u009b\7\37\2\2\u0095\u0096\7\6\2\2\u0096\u0097\5"+
		"\4\3\2\u0097\u0098\7\37\2\2\u0098\u009a\3\2\2\2\u0099\u0095\3\2\2\2\u009a"+
		"\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\33\3\2\2"+
		"\2\u009d\u009b\3\2\2\2\u009e\u00a2\7\3\2\2\u009f\u00a1\5\"\22\2\u00a0"+
		"\u009f\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2"+
		"\2\2\u00a3\u00a8\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a7\5\36\20\2\u00a6"+
		"\u00a5\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2"+
		"\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac\5$\23\2\u00ac"+
		"\u00ad\7\4\2\2\u00ad\35\3\2\2\2\u00ae\u00af\5&\24\2\u00af\u00b0\7\5\2"+
		"\2\u00b0\u00b3\3\2\2\2\u00b1\u00b3\5@!\2\u00b2\u00ae\3\2\2\2\u00b2\u00b1"+
		"\3\2\2\2\u00b3\37\3\2\2\2\u00b4\u00b8\7\3\2\2\u00b5\u00b7\5\36\20\2\u00b6"+
		"\u00b5\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2"+
		"\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\7\4\2\2\u00bc"+
		"!\3\2\2\2\u00bd\u00be\5\4\3\2\u00be\u00bf\5\22\n\2\u00bf\u00c0\7\5\2\2"+
		"\u00c0#\3\2\2\2\u00c1\u00c2\7\16\2\2\u00c2\u00c3\5\62\32\2\u00c3\u00c4"+
		"\7\5\2\2\u00c4%\3\2\2\2\u00c5\u00c9\7\37\2\2\u00c6\u00c8\5(\25\2\u00c7"+
		"\u00c6\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2"+
		"\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cf\7\24\2\2\u00cd"+
		"\u00d0\5\62\32\2\u00ce\u00d0\58\35\2\u00cf\u00cd\3\2\2\2\u00cf\u00ce\3"+
		"\2\2\2\u00d0\'\3\2\2\2\u00d1\u00d2\7\33\2\2\u00d2\u00d3\7\37\2\2\u00d3"+
		")\3\2\2\2\u00d4\u00d5\7\37\2\2\u00d5\u00d7\7\7\2\2\u00d6\u00d8\5\60\31"+
		"\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da"+
		"\7\b\2\2\u00da+\3\2\2\2\u00db\u00dc\7\33\2\2\u00dc\u00dd\5*\26\2\u00dd"+
		"-\3\2\2\2\u00de\u00e2\7\37\2\2\u00df\u00e1\5(\25\2\u00e0\u00df\3\2\2\2"+
		"\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e6"+
		"\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e7\5,\27\2\u00e6\u00e5\3\2\2\2\u00e6"+
		"\u00e7\3\2\2\2\u00e7/\3\2\2\2\u00e8\u00ed\5\62\32\2\u00e9\u00ea\7\6\2"+
		"\2\u00ea\u00ec\5\62\32\2\u00eb\u00e9\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed"+
		"\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\61\3\2\2\2\u00ef\u00ed\3\2\2"+
		"\2\u00f0\u00f1\b\32\1\2\u00f1\u00f2\5\66\34\2\u00f2\u010c\3\2\2\2\u00f3"+
		"\u00f4\f\b\2\2\u00f4\u00f5\7\26\2\2\u00f5\u010b\5\62\32\t\u00f6\u00f7"+
		"\f\7\2\2\u00f7\u00f8\7\31\2\2\u00f8\u010b\5\62\32\b\u00f9\u00fa\f\6\2"+
		"\2\u00fa\u00fb\7\25\2\2\u00fb\u010b\5\62\32\7\u00fc\u00fd\f\5\2\2\u00fd"+
		"\u00fe\7\27\2\2\u00fe\u010b\5\62\32\6\u00ff\u0100\f\4\2\2\u0100\u0101"+
		"\7\30\2\2\u0101\u010b\5\62\32\5\u0102\u0103\f\3\2\2\u0103\u0104\7\25\2"+
		"\2\u0104\u0105\5\62\32\2\u0105\u0106\7\34\2\2\u0106\u0107\5\62\32\2\u0107"+
		"\u0108\7\t\2\2\u0108\u0109\5\62\32\3\u0109\u010b\3\2\2\2\u010a\u00f3\3"+
		"\2\2\2\u010a\u00f6\3\2\2\2\u010a\u00f9\3\2\2\2\u010a\u00fc\3\2\2\2\u010a"+
		"\u00ff\3\2\2\2\u010a\u0102\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010a\3\2"+
		"\2\2\u010c\u010d\3\2\2\2\u010d\63\3\2\2\2\u010e\u010c\3\2\2\2\u010f\u0110"+
		"\t\3\2\2\u0110\u0111\5\66\34\2\u0111\65\3\2\2\2\u0112\u0118\5> \2\u0113"+
		"\u0118\5.\30\2\u0114\u0118\5*\26\2\u0115\u0118\5<\37\2\u0116\u0118\5\64"+
		"\33\2\u0117\u0112\3\2\2\2\u0117\u0113\3\2\2\2\u0117\u0114\3\2\2\2\u0117"+
		"\u0115\3\2\2\2\u0117\u0116\3\2\2\2\u0118\67\3\2\2\2\u0119\u011a\7\17\2"+
		"\2\u011a\u011c\7\23\2\2\u011b\u011d\5:\36\2\u011c\u011b\3\2\2\2\u011c"+
		"\u011d\3\2\2\2\u011d9\3\2\2\2\u011e\u0120\7\7\2\2\u011f\u0121\5\60\31"+
		"\2\u0120\u011f\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123"+
		"\7\b\2\2\u0123;\3\2\2\2\u0124\u0125\7\7\2\2\u0125\u0126\5\62\32\2\u0126"+
		"\u0127\7\b\2\2\u0127=\3\2\2\2\u0128\u0129\t\4\2\2\u0129?\3\2\2\2\u012a"+
		"\u012d\5B\"\2\u012b\u012d\5D#\2\u012c\u012a\3\2\2\2\u012c\u012b\3\2\2"+
		"\2\u012dA\3\2\2\2\u012e\u012f\7\13\2\2\u012f\u0130\7\7\2\2\u0130\u0131"+
		"\5\62\32\2\u0131\u0132\7\b\2\2\u0132\u0135\5 \21\2\u0133\u0134\7\f\2\2"+
		"\u0134\u0136\5 \21\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136C\3"+
		"\2\2\2\u0137\u0138\7\r\2\2\u0138\u0139\7\7\2\2\u0139\u013a\5\62\32\2\u013a"+
		"\u013b\7\b\2\2\u013b\u013c\5 \21\2\u013cE\3\2\2\2\34IY^`ms\u0082\u008f"+
		"\u009b\u00a2\u00a8\u00b2\u00b8\u00c9\u00cf\u00d7\u00e2\u00e6\u00ed\u010a"+
		"\u010c\u0117\u011c\u0120\u012c\u0135";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}