package br.com.brunobrasilweb.springadm.controller;


import br.com.brunobrasilweb.springadm.model.AbstractModel;
import br.com.brunobrasilweb.springadm.service.AbstractService;

import java.io.Serializable;

public abstract class AbstractController<T extends AbstractModel<Long>, Long extends Serializable>{

    protected abstract AbstractService<T, Long> getService();

}
