enum class Nivel {
    BASICO,
    INTERMEDIARIO,
    AVANCADO
}

data class Usuario(val nomeUsuario: String, val matriculaUsuario: String) {
    override fun toString(): String {
        return "$nomeUsuario (matrícula $matriculaUsuario)"
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60) {
    override fun toString(): String {
        return "$nome (Carga horária: $duracao)"
    }
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuario: Usuario) {
        inscritos.addAll(usuario)
    }

    override fun toString(): String {
        //  return "Formação: $nome\nConteúdo educacional: $conteudos\nNível: $nivel\nAlunos
        // inscritos na formação: $inscritos"
        return """
        Formação: $nome
        Conteúdo educacional:$conteudos
        Nível: $nivel
        Alunos matriculados nesta formação: $inscritos
        """.trimIndent()
    }
}

fun generateMatricula(): String {
    return (1..9999).random().toString()
}

fun main() {

    val aluno1 = Usuario("Aluno1", generateMatricula())
    val aluno2 = Usuario("Aluno2", generateMatricula())
    val aluno3 = Usuario("Aluno3", generateMatricula())
    val aluno4 = Usuario("Aluno4", generateMatricula())
    val aluno5 = Usuario("Aluno5", generateMatricula())
    val conteudoEducacionalWeb1 = ConteudoEducacional("Curso Web 1", 360)
    val conteudoEducacionalWeb2 = ConteudoEducacional("Curso Web 2", 200)
    val conteudoEducacionalWeb3 = ConteudoEducacional("Curso Web 3", 150)
    val conteudoEducacionalMobile1 = ConteudoEducacional("Treinamento Mobile 1", 250)
    val conteudoEducacionalMobile2 = ConteudoEducacional("Treinamento Mobile 2", 350)
    val conteudoEducacionalMobile3 = ConteudoEducacional("Treinamento Mobile 3", 200)
    val formacaoWebBasico = Formacao("Web Developer",
        listOf(conteudoEducacionalWeb1), Nivel.BASICO)
    val formacaoWebInterm = Formacao("Web Developer",
        listOf(conteudoEducacionalWeb1, conteudoEducacionalWeb2), Nivel.INTERMEDIARIO)
    val formacaoWebAvanc = Formacao("Web Developer",
        listOf(conteudoEducacionalWeb1, conteudoEducacionalWeb2, conteudoEducacionalWeb3), Nivel.AVANCADO)
    val formacaoMobileBasico = Formacao("Mobile Developer",
        listOf(conteudoEducacionalMobile1), Nivel.BASICO)
    val formacaoMobileInterm = Formacao("Mobile Developer",
        listOf(conteudoEducacionalMobile1, conteudoEducacionalMobile2), Nivel.INTERMEDIARIO)
    val formacaoMobileAvan = Formacao("Mobile Developer",
        listOf(conteudoEducacionalMobile1, conteudoEducacionalMobile2, conteudoEducacionalMobile3), Nivel.AVANCADO)
    formacaoWebBasico.matricular(aluno1, aluno2)
    formacaoWebAvanc.matricular(aluno1, aluno3, aluno4)
    formacaoMobileInterm.matricular(aluno2, aluno5)
    formacaoMobileAvan.matricular(aluno5, aluno2, aluno4)
    formacaoWebBasico.matricular(aluno3, aluno2)
    formacaoMobileBasico.matricular(aluno3, aluno2)
    println(formacaoWebBasico)
    println("\n==============================================================================\n")
    println(formacaoWebInterm)
    println("\n==============================================================================\n")
    println(formacaoWebAvanc)
    println("\n==============================================================================\n")
    println(formacaoMobileBasico)
    println("\n==============================================================================\n")
    println(formacaoMobileInterm)
    println("\n==============================================================================\n")
    println(formacaoMobileAvan)
    println("\n==============================================================================\n")
}
