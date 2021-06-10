// Generated from D:/Documents/GIT/compiler_construction/src/main/antlr/at/tugraz/ist/cc\Jova.g4 by ANTLR 4.8

	package at.tugraz.ist.cc;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JovaParser}.
 */
public interface JovaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JovaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(JovaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(JovaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(JovaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(JovaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#class_decl}.
	 * @param ctx the parse tree
	 */
	void enterClass_decl(JovaParser.Class_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#class_decl}.
	 * @param ctx the parse tree
	 */
	void exitClass_decl(JovaParser.Class_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#class_head}.
	 * @param ctx the parse tree
	 */
	void enterClass_head(JovaParser.Class_headContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#class_head}.
	 * @param ctx the parse tree
	 */
	void exitClass_head(JovaParser.Class_headContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#class_body}.
	 * @param ctx the parse tree
	 */
	void enterClass_body(JovaParser.Class_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#class_body}.
	 * @param ctx the parse tree
	 */
	void exitClass_body(JovaParser.Class_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#ctor}.
	 * @param ctx the parse tree
	 */
	void enterCtor(JovaParser.CtorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#ctor}.
	 * @param ctx the parse tree
	 */
	void exitCtor(JovaParser.CtorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#ctor_body}.
	 * @param ctx the parse tree
	 */
	void enterCtor_body(JovaParser.Ctor_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#ctor_body}.
	 * @param ctx the parse tree
	 */
	void exitCtor_body(JovaParser.Ctor_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#member_decl}.
	 * @param ctx the parse tree
	 */
	void enterMember_decl(JovaParser.Member_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#member_decl}.
	 * @param ctx the parse tree
	 */
	void exitMember_decl(JovaParser.Member_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#id_list}.
	 * @param ctx the parse tree
	 */
	void enterId_list(JovaParser.Id_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#id_list}.
	 * @param ctx the parse tree
	 */
	void exitId_list(JovaParser.Id_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#method_decl}.
	 * @param ctx the parse tree
	 */
	void enterMethod_decl(JovaParser.Method_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#method_decl}.
	 * @param ctx the parse tree
	 */
	void exitMethod_decl(JovaParser.Method_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#method_head}.
	 * @param ctx the parse tree
	 */
	void enterMethod_head(JovaParser.Method_headContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#method_head}.
	 * @param ctx the parse tree
	 */
	void exitMethod_head(JovaParser.Method_headContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(JovaParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(JovaParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#param_list}.
	 * @param ctx the parse tree
	 */
	void enterParam_list(JovaParser.Param_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#param_list}.
	 * @param ctx the parse tree
	 */
	void exitParam_list(JovaParser.Param_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#method_body}.
	 * @param ctx the parse tree
	 */
	void enterMethod_body(JovaParser.Method_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#method_body}.
	 * @param ctx the parse tree
	 */
	void exitMethod_body(JovaParser.Method_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(JovaParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(JovaParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterCompound_stmt(JovaParser.Compound_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitCompound_stmt(JovaParser.Compound_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(JovaParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(JovaParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#ret_stmt}.
	 * @param ctx the parse tree
	 */
	void enterRet_stmt(JovaParser.Ret_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#ret_stmt}.
	 * @param ctx the parse tree
	 */
	void exitRet_stmt(JovaParser.Ret_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(JovaParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(JovaParser.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#member_access}.
	 * @param ctx the parse tree
	 */
	void enterMember_access(JovaParser.Member_accessContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#member_access}.
	 * @param ctx the parse tree
	 */
	void exitMember_access(JovaParser.Member_accessContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#method_invocation}.
	 * @param ctx the parse tree
	 */
	void enterMethod_invocation(JovaParser.Method_invocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#method_invocation}.
	 * @param ctx the parse tree
	 */
	void exitMethod_invocation(JovaParser.Method_invocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#chain_method_invocation}.
	 * @param ctx the parse tree
	 */
	void enterChain_method_invocation(JovaParser.Chain_method_invocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#chain_method_invocation}.
	 * @param ctx the parse tree
	 */
	void exitChain_method_invocation(JovaParser.Chain_method_invocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#id_expr}.
	 * @param ctx the parse tree
	 */
	void enterId_expr(JovaParser.Id_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#id_expr}.
	 * @param ctx the parse tree
	 */
	void exitId_expr(JovaParser.Id_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void enterArg_list(JovaParser.Arg_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void exitArg_list(JovaParser.Arg_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(JovaParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(JovaParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#unary_expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expr(JovaParser.Unary_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#unary_expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expr(JovaParser.Unary_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#primary_expr}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_expr(JovaParser.Primary_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#primary_expr}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_expr(JovaParser.Primary_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#object_alloc}.
	 * @param ctx the parse tree
	 */
	void enterObject_alloc(JovaParser.Object_allocContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#object_alloc}.
	 * @param ctx the parse tree
	 */
	void exitObject_alloc(JovaParser.Object_allocContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#ctor_args}.
	 * @param ctx the parse tree
	 */
	void enterCtor_args(JovaParser.Ctor_argsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#ctor_args}.
	 * @param ctx the parse tree
	 */
	void exitCtor_args(JovaParser.Ctor_argsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#paran_expr}.
	 * @param ctx the parse tree
	 */
	void enterParan_expr(JovaParser.Paran_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#paran_expr}.
	 * @param ctx the parse tree
	 */
	void exitParan_expr(JovaParser.Paran_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(JovaParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(JovaParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#control_stmt}.
	 * @param ctx the parse tree
	 */
	void enterControl_stmt(JovaParser.Control_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#control_stmt}.
	 * @param ctx the parse tree
	 */
	void exitControl_stmt(JovaParser.Control_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(JovaParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(JovaParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JovaParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(JovaParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JovaParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(JovaParser.While_stmtContext ctx);
}