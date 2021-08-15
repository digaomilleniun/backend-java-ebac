package br.com.rpires.adpter;

import java.io.File;

/**
 * @author rodrigo.pires
 */
public interface PersistenciaArquivos {

    //byte[] bytes = Files.readAllBytes(file.toPath());
    public void gravar(File file);

    public File ler(String caminho);
}
