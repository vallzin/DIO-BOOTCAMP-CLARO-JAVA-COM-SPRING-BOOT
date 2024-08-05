import br.com.dio.desfio.dominio.Bootcamp;
import br.com.dio.desfio.dominio.Curso;
import br.com.dio.desfio.dominio.Dev;
import br.com.dio.desfio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Curso curso1 = new Curso();

        curso1.setTitulo("curso Java");
        curso1.setDescricao("descrição curso Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();

        curso2.setTitulo("curso JS");
        curso2.setDescricao("descrição curso JS");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();

        mentoria.setTitulo("br.com.dio.desfio.dominio.Mentoria de Java");
        mentoria.setDescricao("descrição da mentoria Java");
        mentoria.setData(LocalDate.now());

//        System.out.println(curso1);
//        System.out.println(curso2);
//        System.out.println(mentoria);

        Bootcamp bootcamp = new Bootcamp();

        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devVallzin = new Dev();
        devVallzin.setNome("Vallzin");
        devVallzin.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos"+ devVallzin.getConteudosInscritos());
        devVallzin.progredir();
        devVallzin.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Concluídos"+ devVallzin.getConteudosConcluidos());
        System.out.println("Conteúdos Inscritos"+ devVallzin.getConteudosInscritos());
        System.out.println("XP:"+devVallzin.calcularXp());

        System.out.println("------------------");

        Dev devGg = new Dev();
        devGg.setNome("Gg");
        devGg.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos"+ devGg.getConteudosInscritos());
        devGg.progredir();
        devGg.progredir();
        devGg.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Concluídos"+ devGg.getConteudosConcluidos());
        System.out.println("Conteúdos Inscritos"+ devGg.getConteudosInscritos());
        System.out.println("XP:"+devGg.calcularXp());
    }



}