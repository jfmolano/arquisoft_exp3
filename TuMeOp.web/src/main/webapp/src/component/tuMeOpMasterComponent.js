define(['controller/selectionController', 'model/cacheModel', 'model/tuMeOpMasterModel', 'component/_CRUDComponent', 'controller/tabController', 'component/tuMeOpComponent',
 'component/usuarioComponent'
 ,
 'component/tiendaComponent'
 
 ],function(SelectionController, CacheModel, TuMeOpMasterModel, CRUDComponent, TabController, TuMeOpComponent,
 usuariosOpComponent
 ,
 tiendaOPComponent
 ) {
    App.Component.TuMeOpMasterComponent = App.Component.BasicComponent.extend({
        initialize: function() {
            var self = this;
            this.configuration = App.Utils.loadComponentConfiguration('tuMeOpMaster');
            var uComponent = new TuMeOpComponent();
            uComponent.initialize();
            uComponent.render('main');
            Backbone.on(uComponent.componentId + '-post-tuMeOp-create', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-post-tuMeOp-edit', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-pre-tuMeOp-list', function() {
                self.hideChilds();
            });
            Backbone.on('tuMeOp-master-model-error', function(error) {
                Backbone.trigger(uComponent.componentId + '-' + 'error', {event: 'tuMeOp-master-save', view: self, message: error});
            });
            Backbone.on(uComponent.componentId + '-instead-tuMeOp-save', function(params) {
                self.model.set('tuMeOpEntity', params.model);
                if (params.model) {
                    self.model.set('id', params.model.id);
                } else {
                    self.model.unset('id');
                }
                var usuariosOpModels = self.usuariosOpComponent.componentController.usuarioModelList;
                self.model.set('listusuariosOp', []);
                self.model.set('createusuariosOp', []);
                self.model.set('updateusuariosOp', []);
                self.model.set('deleteusuariosOp', []);
                for (var i = 0; i < usuariosOpModels.models.length; i++) {
                    var m =usuariosOpModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createusuariosOp').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updateusuariosOp').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < usuariosOpModels.deletedModels.length; i++) {
                    var m = usuariosOpModels.deletedModels[i];
                    self.model.get('deleteusuariosOp').push(m.toJSON());
                }
                var tiendaOPModels = self.tiendaOPComponent.componentController.tiendaModelList;
                self.model.set('listtiendaOP', []);
                self.model.set('createtiendaOP', []);
                self.model.set('updatetiendaOP', []);
                self.model.set('deletetiendaOP', []);
                for (var i = 0; i < tiendaOPModels.models.length; i++) {
                    var m =tiendaOPModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createtiendaOP').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updatetiendaOP').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < tiendaOPModels.deletedModels.length; i++) {
                    var m = tiendaOPModels.deletedModels[i];
                    self.model.get('deletetiendaOP').push(m.toJSON());
                }
                self.model.save({}, {
                    success: function() {
                        Backbone.trigger(uComponent.componentId + '-post-tuMeOp-save', self);
                    },
                    error: function(error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'tuMeOp-master-save', view: self, error: error});
                    }
                });
            });
        },
        renderChilds: function(params) {
            var self = this;
            this.tabModel = new App.Model.TabModel(
                    {
                        tabs: [
                            {label: "Usuarios Op", name: "usuariosOp", enable: true},
                            ,
                            {label: "Tienda O P", name: "tiendaOP", enable: true},
                        ]
                    }
            );

            this.tabs = new TabController({model: this.tabModel});

            this.tabs.render('tabs');
            App.Model.TuMeOpMasterModel.prototype.urlRoot = this.configuration.context;
            var options = {
                success: function() {
					self.usuariosOpComponent = new usuariosOpComponent();
                    self.usuariosOpModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.UsuarioModel), self.model.get('listusuariosOp'));
                    self.usuariosOpComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.UsuarioModel),
                        listModelClass: App.Utils.createCacheList(App.Model.UsuarioModel, App.Model.UsuarioList, self.usuariosOpModels)
                    });
                    self.usuariosOpComponent.render(self.tabs.getTabHtmlId('usuariosOp'));
                    Backbone.on(self.usuariosOpComponent.componentId + '-post-usuario-create', function(params) {
                        params.view.currentUsuarioModel.setCacheList(params.view.usuarioModelList);
                    });
					self.tiendaOPComponent = new tiendaOPComponent();
                    self.tiendaOPModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.TiendaModel), self.model.get('listtiendaOP'));
                    self.tiendaOPComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.TiendaModel),
                        listModelClass: App.Utils.createCacheList(App.Model.TiendaModel, App.Model.TiendaList, self.tiendaOPModels)
                    });
                    self.tiendaOPComponent.render(self.tabs.getTabHtmlId('tiendaOP'));
                    Backbone.on(self.tiendaOPComponent.componentId + '-post-tienda-create', function(params) {
                        params.view.currentTiendaModel.setCacheList(params.view.tiendaModelList);
                    });
                    self.usuariosOpToolbarModel = self.usuariosOpComponent.toolbarModel.set(App.Utils.Constans.referenceToolbarConfiguration);
                    self.usuariosOpComponent.setToolbarModel(self.usuariosOpToolbarModel);                    
                    self.tiendaOPToolbarModel = self.tiendaOPComponent.toolbarModel.set(App.Utils.Constans.referenceToolbarConfiguration);
                    self.tiendaOPComponent.setToolbarModel(self.tiendaOPToolbarModel);                    
                	
                     
                
                    $('#tabs').show();
                },
                error: function() {
                    Backbone.trigger(self.componentId + '-' + 'error', {event: 'tuMeOp-edit', view: self, id: id, data: data, error: error});
                }
            };
            if (params.id) {
                self.model = new App.Model.TuMeOpMasterModel({id: params.id});
                self.model.fetch(options);
            } else {
                self.model = new App.Model.TuMeOpMasterModel();
                options.success();
            }


        },
        hideChilds: function() {
            $('#tabs').hide();
        }
    });

    return App.Component.TuMeOpMasterComponent;
});