package dio.web.api.handler;

public class CampoOgrigatorioException extends BusinessException{

    public CampoOgrigatorioException(String campo) {
        super("O campo %s é obrigatório", campo);
    }

}
