// Generated from D:/Documents/GIT/compiler_construction/src/main/antlr/at/tugraz/ist/cc\Jova.g4 by ANTLR 4.8

	package at.tugraz.ist.cc;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JovaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JovaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JovaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(JovaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(JovaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#class_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_decl(JovaParser.Class_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#class_head}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_head(JovaParser.Class_headContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#class_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_body(JovaParser.Class_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#ctor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtor(JovaParser.CtorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#ctor_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtor_body(JovaParser.Ctor_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#member_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember_decl(JovaParser.Member_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#id_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId_list(JovaParser.Id_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#method_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_decl(JovaParser.Method_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#method_head}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_head(JovaParser.Method_headContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(JovaParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#param_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_list(JovaParser.Param_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#method_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_body(JovaParser.Method_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(JovaParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#compound_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_stmt(JovaParser.Compound_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(JovaParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#ret_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRet_stmt(JovaParser.Ret_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#assign_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_stmt(JovaParser.Assign_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#member_access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember_access(JovaParser.Member_accessContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#method_invocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_invocation(JovaParser.Method_invocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#chain_method_invocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChain_method_invocation(JovaParser.Chain_method_invocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#id_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId_expr(JovaParser.Id_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#arg_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg_list(JovaParser.Arg_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(JovaParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#unary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_expr(JovaParser.Unary_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#primary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary_expr(JovaParser.Primary_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#object_alloc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject_alloc(JovaParser.Object_allocContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#ctor_args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtor_args(JovaParser.Ctor_argsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#paran_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParan_expr(JovaParser.Paran_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(JovaParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#control_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControl_stmt(JovaParser.Control_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(JovaParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JovaParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(JovaParser.While_stmtContext ctx);
}