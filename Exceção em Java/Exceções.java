try {
    //bloco de código monitorado
    } 
    catch ( ExcecaoTipo1 Obj) {
    //tratador de exceção para o tipo 1
    }
    catch ( ExcecaoTipo2 Obj) {
    //tratador de exceção para o tipo 2
    }
    ...//“n” blocos catch
    finally {
    // bloco de código a ser executado após o fim da execução do bloco “try”
    } 

    //Quando uma exceção não é adequadamente capturada e tratada, o interpretador mostrará uma mensagem de erro com informações sobre o problema ocorrido e encerrará o programa. Vejamos o exemplo mostrado no código 2

    //Código 2: Exemplo de código sujeito a exceção em tempo de execução:

    public class Principal {
        public static void main ( String args [ ] ) throws InterruptedException {
            int divisor , dividendo , quociente = 0;
            String controle = "s";
	        
            Scanner s = new Scanner ( System.in );
            do {    
                System.out.println ( "Entre com o dividendo." );
                dividendo = s.nextInt();
                System.out.println ( "Entre com o divisor." );
                divisor = s.nextInt();
                quociente = dividendo / divisor;
                System.out.println ( "O quociente é: " + quociente );
                System.out.println ( "Repetir?" );
                controle = s.next().toString();
            } while ( controle.equals( "s" ) );
            s.close();
    }    
} 

//A execução desse código é sujeita a erros ocasionados na execução. Nas condições normais, o programa executará indefinidamente até que escolhamos um valor diferente de “s” para a pergunta “Repetir?”. Um dos erros a que ele está sujeito é a divisão por zero. Como não estamos tratando essa exceção, se ela ocorrer teremos o fim do programa. Observe:

//Exemplo de código sujeito a erro divisão por zero.

Entre com o dividendo.
10
Entre com o divisor.
0
Exception in thread "main" java.lang.ArithmeticException: / by zero
    at com.mycompany.teste.Principal.main(Principal.java:26)
Command execution failed.
org.apache.commons.exec.ExecuteException: Process exited with an error: 1 (Exit value: 1)
        at org.apache.commons.exec.DefaultExecutor.executeInternal (DefaultExecutor.java:404)
        at org.apache.commons.exec.DefaultExecutor.execute (DefaultExecutor.java:166)
        at org.codehaus.mojo.exec.ExecMojo.executeCommandLine (ExecMojo.java:982)
        at org.codehaus.mojo.exec.ExecMojo.executeCommandLine (ExecMojo.java:929)
        at org.codehaus.mojo.exec.ExecMojo.execute (ExecMojo.java:457)
        at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo (DefaultBuildPluginManager.java:137)
        at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:210)
        at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:156)
        at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:148)
        at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:117)
        at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:81)
        at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build (SingleThreadedBuilder.java:56)
        at org.apache.maven.lifecycle.internal.LifecycleStarter.execute (LifecycleStarter.java:128)
        at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:305)
        at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:192)
        at org.apache.maven.DefaultMaven.execute (DefaultMaven.java:105)
        at org.apache.maven.cli.MavenCli.execute (MavenCli.java:957)
        at org.apache.maven.cli.MavenCli.doMain (MavenCli.java:289)
        at org.apache.maven.cli.MavenCli.main (MavenCli.java:193)
        at jdk.internal.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
        at jdk.internal.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:64)
        at jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke (Method.java:564)
        at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced (Launcher.java:282)
        at org.codehaus.plexus.classworlds.launcher.Launcher.launch (Launcher.java:225)
        at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode (Launcher.java:406)
        at org.codehaus.plexus.classworlds.launcher.Launcher.main (Launcher.java:347)
------------------------------------------------------------------------
BUILD FAILURE
------------------------------------------------------------------------
Total time:  20.179 s
Finished at: 2021-05-22T14:03:57-03:00
------------------------------------------------------------------------
Failed to execute goal org.codehaus.mojo:exec-maven-plugin:3.0.0:exec (default-cli) on project teste: Command execution failed.: Process exited with an error: 1 (Exit value: 1) -> [Help 1]
	 
To see the full stack trace of the errors, re-run Maven with the -e switch.
Re-run Maven using the -X switch to enable full debug logging.
	 
For more information about the errors and possible solutions, please read the following articles: 
[Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException

//Vendo a linha número 42, observamos a mensagem “(...) Process exited with an error (…)”, que indica o término abrupto do programa. Veja agora como a captura e o tratamento da exceção beneficia o programa. Vamos substituir a linha 12 do código 2 pelas instruções mostradas no código 4 a seguir:

//: Envolvendo a divisão num bloco try-catch:

try {
    quociente = dividendo / divisor;
} catch (Exception e)
   { 
    System.out.println( "ERRO: Divisão por zero!" );
}


//Confira a saída para o código modificado:

Entre com o dividendo.
10
Entre com o divisor.
0
ERRO: Divisão por zero!
O quociente é: 0
Repetir?
s
Entre com o dividendo.
10
Entre com o divisor.
5
O quociente é: 2
Repetir?
n
------------------------------------------------------------------------
BUILD SUCCESS
-----------------------

//Note que agora o programa foi encerrado de maneira normal, apesar da divisão por zero provocada na linha 4. Quando o erro ocorreu, a exceção foi lançada e capturada pelo bloco catch, como vemos na linha 5. A linha 6 mostrou o valor de “quociente” sendo zero, conforme inicializamos a variável na linha 3 do código 2. Se você tentar compilar o programa sem essa inicialização, verá que sem o bloco try-catch não é gerado erro, mas, quando o utilizamos, o interpretador Java nos obriga a inicializar a variável.


