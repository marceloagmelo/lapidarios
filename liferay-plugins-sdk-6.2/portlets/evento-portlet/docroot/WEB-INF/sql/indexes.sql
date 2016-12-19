create index IX_7A42B59D on evento (companyId, groupId);
create index IX_DF38E4AA on evento (companyId, groupId, nome);
create index IX_491BBE63 on evento (companyId, groupId, userResponsavelId);
create index IX_7A687B61 on evento (companyId, groupId, userResponsavelNome);
create index IX_19DF01B9 on evento (uuid_);
create index IX_7340E4CF on evento (uuid_, companyId);
create unique index IX_60A5311 on evento (uuid_, groupId);

create index IX_172A8937 on evento_agenda (companyId, groupId, dataEvento, status);
create index IX_BA89BA27 on evento_agenda (companyId, groupId, eventoAgendaId, dataEvento, status);
create index IX_77479BB on evento_agenda (companyId, groupId, eventoId, dataEvento, status);
create index IX_C0FFA3A8 on evento_agenda (companyId, groupId, eventoId, status);
create index IX_36DA6E6 on evento_agenda (companyId, groupId, eventoNome, status);
create index IX_578FA7FE on evento_agenda (companyId, groupId, localId, status);
create index IX_360DEDBC on evento_agenda (companyId, groupId, localNome, status);
create index IX_C9940D24 on evento_agenda (companyId, groupId, status);
create index IX_A08A9708 on evento_agenda (companyId, groupId, userResponsavelId, status);
create index IX_2C094246 on evento_agenda (companyId, groupId, userResponsavelNome, status);
create index IX_30599978 on evento_agenda (uuid_);
create index IX_F29C4FB0 on evento_agenda (uuid_, companyId);
create unique index IX_2D550232 on evento_agenda (uuid_, groupId);

create index IX_14FE4E83 on evento_inscricao (companyId, groupId);
create index IX_A7CC9519 on evento_inscricao (companyId, groupId, createUserId);
create index IX_50902D73 on evento_inscricao (companyId, groupId, eventoAgendaId);
create index IX_55759009 on evento_inscricao (companyId, groupId, eventoAgendaId, createUserId);
create index IX_ED6C56C7 on evento_inscricao (companyId, groupId, eventoId);
create index IX_807423B on evento_inscricao (companyId, groupId, userNome);
create index IX_D9C56C87 on evento_inscricao (eventoAgendaId, createUserId);
create index IX_ADFEEB13 on evento_inscricao (uuid_);
create index IX_C9B97F35 on evento_inscricao (uuid_, companyId);
create unique index IX_5E924EF7 on evento_inscricao (uuid_, groupId);

create index IX_EC60F49C on evento_nao_inscrito (companyId, groupId);
create index IX_2A7D818C on evento_nao_inscrito (companyId, groupId, eventoAgendaId);
create index IX_91ED4462 on evento_nao_inscrito (companyId, groupId, eventoAgendaId, createUserId);
create index IX_488CF1A0 on evento_nao_inscrito (companyId, groupId, eventoId);
create index IX_6327DD14 on evento_nao_inscrito (companyId, groupId, userNome);
create index IX_34E60760 on evento_nao_inscrito (eventoAgendaId, createUserId);
create index IX_C32B505A on evento_nao_inscrito (uuid_);
create index IX_3990D78E on evento_nao_inscrito (uuid_, companyId);
create unique index IX_14E5E990 on evento_nao_inscrito (uuid_, groupId);

create index IX_C57AF73 on local (companyId, groupId);
create index IX_BA64A600 on local (companyId, groupId, nome);
create index IX_E64AC423 on local (uuid_);
create index IX_14D65C25 on local (uuid_, companyId);
create unique index IX_D021A7E7 on local (uuid_, groupId);