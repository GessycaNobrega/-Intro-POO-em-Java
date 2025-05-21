public abstract class GenericDAO<E,K> {
   protected Connection getConnection() throws Exception{
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    return DriverManager.getConnection(
        "jdbc:derby://localhost:1527/escola",
        "escola", "escola");
  }
  protected Statement getStatement() throws Exception{
   	return getConnection().createStatement();
  }
  protected void closeStatement(Statement st) throws Exception{
   	st.getConnection().close();
  }
  public abstract void incluir(E entidade);
  public abstract void excluir(K chave);
  public abstract void alterar(E entidade);
  public abstract E obter(K chave);
  public abstract List<E> obterTodos();
  } 

  //Se você quiser utilizar um banco de dados Oracle, com acesso local e instância padrão XE, mantendo o usuário e a senha definidos, modifique o corpo do método getConnection, conforme sugerido no trecho de código seguinte:

    Class.forName("oracle.jdbc.OracleDriver");
  return DriverManager.getConnection(
          jdbc:oracle:thin:@localhost:1521:XE",
         "escola","escola"); 
