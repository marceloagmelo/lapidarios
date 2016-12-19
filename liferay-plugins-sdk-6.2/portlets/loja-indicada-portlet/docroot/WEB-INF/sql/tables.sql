create table loja_indicada (
	uuid_ VARCHAR(75) null,
	lojaIndicadaId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	createUserId LONG,
	modifiedUserId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	idLoja VARCHAR(75) null,
	lojaIndicadaAtual BOOLEAN
);