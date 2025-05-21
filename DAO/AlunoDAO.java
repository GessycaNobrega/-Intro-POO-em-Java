import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO extends GenericDAO<Aluno, String>{
	         @Override
	         public List<Aluno> obterTodos() {
		               List<Aluno> lista = new ArrayList<>();
		               try {
			                     ResultSet r1 = getStatement().executeQuery(
						                            "SELECT * FROM ALUNO");
			                     while(r1.next())
				                  lista.add(new Aluno(r1.getString("MATRICULA"),
				                  r1.getString("NOME"),r1.getInt("ENTRADA")));
			                     closeStatement(r1.getStatement());
		               }catch(Exception e){
	               	}
                    return lista;        
	         }
	         @Override
	         public Aluno obter(String chave) {
		                Aluno aluno = null;
		                try {
		                     	 PreparedStatement ps = 
				                 getConnection().prepareStatement(
				                 "SELECT * FROM ALUNO WHERE MATRICULA = ?");
                                 ps.setString(1, chave);
			                      ResultSet r1 = ps.executeQuery();
			                      if (r1.next())
				                 aluno = new Aluno(r1.getString("MATRICULA"),
						                                 r1.getString("NOME"),
					                                                  r1.getInt("ENTRADA"));
			                      closeStatement(ps);
                                  } catch (Exception e) {
		              }
		              return aluno;
	         }
} 

