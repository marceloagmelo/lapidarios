create table evento (
	uuid_ VARCHAR(75) null,
	eventoId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	createUserId LONG,
	modifiedUserId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	nome STRING null,
	descricao STRING null,
	userResponsavelId LONG,
	userResponsavelNome VARCHAR(75) null,
	versao DOUBLE,
	imagemId LONG,
	articleId LONG
);

create table evento_agenda (
	uuid_ VARCHAR(75) null,
	eventoAgendaId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	createUserId LONG,
	modifiedUserId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	dataEvento DATE null,
	horaEvento VARCHAR(75) null,
	qtdeVagas INTEGER,
	qtdeVagasPreenchida INTEGER,
	gratuito BOOLEAN,
	valor DOUBLE,
	userResponsavelId LONG,
	userResponsavelNome VARCHAR(75) null,
	eventoId LONG,
	eventoNome STRING null,
	localId LONG,
	localNome VARCHAR(75) null,
	observacao STRING null,
	versao DOUBLE,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	classNameId LONG,
	classPK LONG
);

create table evento_inscricao (
	uuid_ VARCHAR(75) null,
	eventoInscricaoId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	createUserId LONG,
	createDate DATE null,
	eventoAgendaId LONG,
	eventoId LONG,
	userNome VARCHAR(75) null
);

create table evento_nao_inscrito (
	uuid_ VARCHAR(75) null,
	eventoNaoInscritoId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	createUserId LONG,
	createDate DATE null,
	eventoAgendaId LONG,
	eventoId LONG,
	userNome VARCHAR(75) null
);

create table local (
	uuid_ VARCHAR(75) null,
	localId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	createUserId LONG,
	modifiedUserId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	nome VARCHAR(75) null,
	endLogradouro VARCHAR(75) null,
	endNumero VARCHAR(75) null,
	endComplemento VARCHAR(75) null,
	endCep VARCHAR(75) null,
	endBairro VARCHAR(75) null,
	endCidade VARCHAR(75) null,
	endUf VARCHAR(75) null,
	endPais VARCHAR(75) null,
	pontoReferencia STRING null,
	versao DOUBLE
);